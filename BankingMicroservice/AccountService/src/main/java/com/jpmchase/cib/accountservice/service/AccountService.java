package com.jpmchase.cib.accountservice.service;

import com.jpmchase.cib.accountservice.dto.AccountRequestDTO;
import com.jpmchase.cib.accountservice.model.Account;
import com.jpmchase.cib.accountservice.repository.AccountRepo;
import com.jpmchase.cib.accountservice.transform.AccountRequestResponseTransformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    private final AccountRequestResponseTransformation transformation;

    public AccountService(AccountRepo accountRepo, AccountRequestResponseTransformation transformation) {
        this.accountRepo = accountRepo;
        this.transformation = transformation;
    }

    @Transactional
    public Account getAccountByAcctNo(String acctNo) {
        Optional<Account> optionalAccount = accountRepo.findByAcctNo(acctNo);
        return optionalAccount.isPresent() ? optionalAccount.get() : null;
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public String saveAccount(AccountRequestDTO requestDTO) {
        return Objects.nonNull(accountRepo.save(transformation.tranfromRequestDTOToModel(requestDTO))) ? "Record Submitted" : "Error Occured";
    }
}
