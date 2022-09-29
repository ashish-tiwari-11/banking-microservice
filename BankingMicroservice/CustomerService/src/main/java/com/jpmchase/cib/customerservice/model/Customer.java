package com.jpmchase.cib.customerservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblcustomer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long custId;

    @Column(nullable = false, length = 25, name = "custFname")
    private String custFname;

    @Column(nullable = false, length = 25, name = "custLname")
    private String custLname;

    @Column(nullable = false, length = 50, name = "custEmail")
    private String custEmail;

    @Column(nullable = false, length = 10, name = "custMobile")
    private String custMobile;

    @Column(name = "custCreationDT")
    private LocalDateTime custCreationDT;

    @ManyToOne
    @JoinColumn(name = "branchId", nullable = false)
    private Branch branch;
}
