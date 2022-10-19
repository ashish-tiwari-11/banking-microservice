package com.jpmchase.cib.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequestDTO {

    private String accountNo;
    private String accountType;
    private LocalDateTime accountCreationDT;
    private double accountBalance;
    private Long custId;

}
