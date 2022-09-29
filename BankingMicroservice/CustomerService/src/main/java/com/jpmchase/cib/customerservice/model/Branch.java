package com.jpmchase.cib.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblbranch")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchId;

    @Column(name = "branchCode", nullable = false, unique = true)
    private String branchCode;

    @Column(unique = true, nullable = false, name = "branchAddress")
    private String branchAddress;

    @Column(name = "branchCreationDT")
    private LocalDateTime branchCreationDT;

    @OneToMany(mappedBy = "branch")
    Set<Customer> customerSet;

}
