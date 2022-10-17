package com.jpmchase.cib.loanservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private Long custId;
    private String custFname;
    private String custLname;
    private String custEmail;
    private String custMobile;
    private LocalDateTime custCreationDT;
    private Long branchId;
}
