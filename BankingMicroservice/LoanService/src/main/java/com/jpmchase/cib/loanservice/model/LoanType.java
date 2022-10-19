package com.jpmchase.cib.loanservice.model;

import javax.persistence.*;

@Entity
@Table(name = "tblLoanType")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanTypeId;

    @Column(name = "loanType", nullable = false)
    private String loanType;

    @Column(name = "loanTypeDesc", nullable = false)
    private String loanTypeDesc;

}
