package com.jpmchase.cib.loanservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    private Long branchId;
    private String branchCode;
    private String branchAddress;
    private LocalDateTime branchCreationDT;

}
