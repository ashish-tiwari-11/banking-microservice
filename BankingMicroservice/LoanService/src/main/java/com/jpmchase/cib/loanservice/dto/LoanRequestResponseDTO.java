package com.jpmchase.cib.loanservice.dto;

import com.jpmchase.cib.loanservice.model.LoanType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequestResponseDTO {

    private String loanAcctNo;
    private LocalDate loanStartDate;
    private int loanTenure;
    private LoanType loanType;
    private float loanROI;
    private LocalDateTime loanCreationDT;
    private int loanAmount;
    private int loanPendingAmount;
    private String acctNo;

}
