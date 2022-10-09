package com.jpmchase.cib.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblaccount")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acctId")
    private Long accountId;

    @Column(name = "acctNo")
    private String accountNo;

    @Column(name = "acctType", nullable = false)
    private String accountType;

    @Column(name = "acctCreationDT", nullable = false)
    private LocalDateTime accountCreationDT;

    @Column(name= "custId", nullable = false, unique = true)
    private Long custId;

}
