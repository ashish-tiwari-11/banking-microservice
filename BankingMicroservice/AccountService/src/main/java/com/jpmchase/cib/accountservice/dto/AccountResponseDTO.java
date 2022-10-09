package com.jpmchase.cib.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {

    private Long accountId;
    private String accountNo;
    private String accountType;
    private LocalDateTime accountCreationDT;
    private CustomerResponseDTO customerResponseDTO;
}
