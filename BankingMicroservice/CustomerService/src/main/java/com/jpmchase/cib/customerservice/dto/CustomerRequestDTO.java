package com.jpmchase.cib.customerservice.dto;

import com.jpmchase.cib.customerservice.model.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data()
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
    private Long custId;
    private String custFname;
    private String custLname;
    private String custMobile;
    private String custEmail;
    private Long branchId;
    private Branch branch;
}
