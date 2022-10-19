package com.jpmchase.cib.loanservice.controller;

import com.jpmchase.cib.loanservice.dto.LoanRequestResponseDTO;
import com.jpmchase.cib.loanservice.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/request")
    public ResponseEntity<String> createLoanRequest(@RequestBody LoanRequestResponseDTO requestDTO){
        return ResponseEntity.ok(loanService.createAloanRequest(requestDTO));
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<LoanRequestResponseDTO> getLoanByLoanAcctNo(@PathVariable(value = "loanId") String loanAcctNo){
        return ResponseEntity.ok(loanService.getLoanAcctNo(loanAcctNo));
    }

    @GetMapping("/account")
    public ResponseEntity<LoanRequestResponseDTO> getLoanByAccountNo(@RequestParam(value = "acctNo") String acctNo){
        return ResponseEntity.ok(loanService.getLoanByAccountNo(acctNo));
    }
}
