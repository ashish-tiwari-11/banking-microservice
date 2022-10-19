package com.jpmchase.cib.accountservice.service;

import com.jpmchase.cib.accountservice.dto.AccountRequestDTO;
import com.jpmchase.cib.accountservice.dto.AccountResponseDTO;
import com.jpmchase.cib.accountservice.model.Account;
import com.jpmchase.cib.accountservice.model.Branch;
import com.jpmchase.cib.accountservice.model.Customer;
import com.jpmchase.cib.accountservice.repository.AccountRepo;
import com.jpmchase.cib.accountservice.transform.AccountRequestResponseTransformation;
import com.netflix.discovery.util.StringUtil;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

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

    public List<AccountResponseDTO> getAllAccounts() {
        List<AccountResponseDTO> responseDTOS = new ArrayList<>();
        Consumer<Account> accountConsumer = account -> {
            Customer customer = restTemplate.getForObject("http://CUSTOMERSERVICE/api/v1/customer/" + account.getCustId(), Customer.class);
            Branch branch = restTemplate.getForObject("http://CUSTOMERSERVICE/api/v1/customer/" + account.getCustId() + "/branch", Branch.class);
            responseDTOS.add(transformation.fromAccountEntityToResponseDTO(account, customer, branch));
        };
        accountRepo.findAll().stream().forEach(accountConsumer);
        return responseDTOS;
    }

    public String saveAccount(AccountRequestDTO requestDTO) {
        requestDTO.setAccountNo("JPMC".concat("11").concat(StringUtils.leftPad(String.valueOf(getLastAcctId()),4,'0')));
        accountRepo.save(transformation.transfromAccountRequestDTOToModel(requestDTO));
        return "Account Created";
    }

    public Long getLastAcctId(){
        List<Account> accounts = accountRepo.findAll(Sort.by(Sort.Direction.DESC, "accountId"));
        if(Objects.nonNull(accounts) && accounts.size() >0 ){
            return  accounts.get(0).getAccountId();
        }
        return  1L;
    }

}
