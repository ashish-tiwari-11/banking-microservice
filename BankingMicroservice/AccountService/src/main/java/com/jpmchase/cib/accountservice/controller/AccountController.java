package com.jpmchase.cib.accountservice.controller;

import com.jpmchase.cib.accountservice.dto.AccountRequestDTO;
import com.jpmchase.cib.accountservice.model.Account;
import com.jpmchase.cib.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account/{acctNo}")
    public ResponseEntity<Account> getAccountById(@PathVariable(value = "acctNo") String acctNo) {
        return new ResponseEntity<>(accountService.getAccountByAcctNo(acctNo), HttpStatus.OK);
    }

    @GetMapping("/account/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity<String> newAccount(@RequestBody @Validated AccountRequestDTO requestDTO) {
        return new ResponseEntity<>(accountService.saveAccount(requestDTO), HttpStatus.OK);
    }

}
