package com.jpmchase.cib.accountservice.transform;

import com.jpmchase.cib.accountservice.dto.AccountRequestDTO;
import com.jpmchase.cib.accountservice.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AccountRequestResponseTransformation {

    public Account tranfromRequestDTOToModel(AccountRequestDTO requestDTO) {
        Account account = new Account();

        return account;
    }

}
