package com.jpmchase.cib.customerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private Long custId;
    private String custFname;
    private String custLname;
    private String custMobile;
    private String custEmail;
    private LocalDateTime custCreationDT;
    private BranchResponseDTO branchResponseDTO;

}
