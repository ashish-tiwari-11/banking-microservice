package com.jpmchase.cib.loanservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanTypeResponseDTO {

    private String loanType;
    private String loanTypeDesc;

}
