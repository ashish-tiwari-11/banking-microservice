package com.jpmchase.cib.cardservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tblcard")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    private Long cardId;

    @Column(name = "customerId")
    private int customerId;

    @Column(name = "cardNumber")
    private String cardNumber;

    @Column(name = "cardType")
    private String cardType;

    @Column(name = "cardTotalLimit")
    private int cardTotalLimit;

    @Column(name = "cardAmountUsed")
    private int amountUsed;

    @Column(name = "cardAvailableAmount")
    private int availableAmount;

    @Column(name = "cardCreateDT")
    private LocalDate cardCreateDT;

}
