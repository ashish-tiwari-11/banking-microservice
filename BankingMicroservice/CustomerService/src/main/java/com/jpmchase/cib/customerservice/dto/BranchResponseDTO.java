package com.jpmchase.cib.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchResponseDTO {
    private String branchCode;
    private String branchAddress;
}
