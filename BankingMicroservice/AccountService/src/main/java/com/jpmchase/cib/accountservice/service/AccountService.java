package com.jpmchase.cib.accountservice.service;

import com.jpmchase.cib.accountservice.dto.AccountRequestDTO;
import com.jpmchase.cib.accountservice.dto.AccountResponseDTO;
import com.jpmchase.cib.accountservice.model.Account;
import com.jpmchase.cib.accountservice.model.Branch;
import com.jpmchase.cib.accountservice.model.Customer;
import com.jpmchase.cib.accountservice.repository.AccountRepo;
import com.jpmchase.cib.accountservice.transform.AccountRequestResponseTransformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepo accountRepo;

    private final AccountRequestResponseTransformation transformation;

    private final RestTemplate restTemplate;

    public AccountService(AccountRepo accountRepo, AccountRequestResponseTransformation transformation, RestTemplate restTemplate) {
        this.accountRepo = accountRepo;
        this.transformation = transformation;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public AccountResponseDTO getAccountByAcctNo(String acctNo) {
        Optional<Account> optionalAccount = accountRepo.findByAccountNo(acctNo);
        Account account = optionalAccount.get();
        Customer customer = restTemplate.getForObject("http://CUSTOMERSERVICE/api/v1/customer/" + account.getCustId(), Customer.class);
        Branch branch = restTemplate.getForObject("http://CUSTOMERSERVICE/api/v1/customer/" + account.getCustId() + "/branch", Branch.class);
        return optionalAccount.isPresent() ? transformation.fromAccountEntityToResponseDTO(account, customer, branch) : null;
    }

    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }

    public String saveAccount(AccountRequestDTO requestDTO) {
        accountRepo.save(transformation.transfromAccountRequestDTOToModel(requestDTO));
        return "Account Created";
    }
}
