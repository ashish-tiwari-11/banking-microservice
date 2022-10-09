package com.jpmchase.cib.accountservice.transform;

import com.jpmchase.cib.accountservice.dto.AccountRequestDTO;
import com.jpmchase.cib.accountservice.dto.AccountResponseDTO;
import com.jpmchase.cib.accountservice.dto.BranchResponseDTO;
import com.jpmchase.cib.accountservice.dto.CustomerResponseDTO;
import com.jpmchase.cib.accountservice.model.Account;
import com.jpmchase.cib.accountservice.model.Branch;
import com.jpmchase.cib.accountservice.model.Customer;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Objects;


@Component
public class AccountRequestResponseTransformation {

    public Account transfromAccountRequestDTOToModel(AccountRequestDTO requestDTO) {
        Account account = new Account();
        if(Objects.nonNull(requestDTO)){
            account.setAccountNo(requestDTO.getAccountNo());
            account.setAccountType(requestDTO.getAccountType());
            account.setAccountCreationDT(LocalDateTime.now());
            account.setCustId(requestDTO.getCustId());
        }
        return account;
    }

    private BranchResponseDTO fromBranchEntityToResponseDTO(Branch branch) {
        BranchResponseDTO branchResponseDTO = new BranchResponseDTO();
        branchResponseDTO.setBranchCode(branch.getBranchCode());
        branchResponseDTO.setBranchAddress(branch.getBranchAddress());
        return branchResponseDTO;
    }

    public CustomerResponseDTO fromCustomerEntityToResponseDTO(Customer customer) {
        CustomerResponseDTO responseDTO = new CustomerResponseDTO();
        responseDTO.setCustId(customer.getCustId());
        responseDTO.setCustFname(customer.getCustFname());
        responseDTO.setCustLname(customer.getCustLname());
        responseDTO.setCustEmail(customer.getCustEmail());
        responseDTO.setCustMobile(customer.getCustMobile());
        responseDTO.setCustCreationDT(customer.getCustCreationDT());
        return responseDTO;
    }

    public AccountResponseDTO fromAccountEntityToResponseDTO(Account account,Customer customer,Branch branch){
        AccountResponseDTO responseDTO  =  new AccountResponseDTO();
        responseDTO.setAccountId(account.getAccountId());
        responseDTO.setAccountType(account.getAccountType());
        responseDTO.setAccountNo(account.getAccountNo());
        responseDTO.setAccountCreationDT(account.getAccountCreationDT());

        CustomerResponseDTO customerResponseDTO = fromCustomerEntityToResponseDTO(customer);
        customerResponseDTO.setBranchResponseDTO(fromBranchEntityToResponseDTO(branch));

        responseDTO.setCustomerResponseDTO(customerResponseDTO);
        return responseDTO;
    }

}
