package com.jpmchase.cib.loanservice.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tblLoan")
public class Loan implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "loanAcctNo", unique = true)
    private String loanAcctNo;

    @Column(name = "loanStartDate", nullable = false)
    private LocalDate loanStartDate;

    @Column(name = "loanTenure", nullable = false)
    private int loanTenure;

    @Column(name = "loanTenureType", nullable = false)
    private String loanTenureType;

    @Column(name = "loanType", nullable = false)
    private String loanType;

    @Column(name = "loanROI", nullable = false)
    private float loanROI;

    @Column(name = "loanCreationDT", nullable = false)
    private LocalDateTime loanCreationDT;

    @Column(name = "loanAmount", nullable = false)
    private int loanAmount;

    @Column(name = "loanPendingAmount", nullable = false)
    private int loanPendingAmount;

    @Column(name= "customerId", nullable = false)
    private Long customerId;

}
