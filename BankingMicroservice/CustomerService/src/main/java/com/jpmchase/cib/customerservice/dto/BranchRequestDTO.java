package com.jpmchase.cib.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequestDTO {
    private String branchCode;
    private String branchAddress;
}
