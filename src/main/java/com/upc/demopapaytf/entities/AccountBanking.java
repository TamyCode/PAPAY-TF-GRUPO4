package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "AccountBanking")
public class AccountBanking {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numberAccountBanking;

    @Column(name = "typeAccountBanking",nullable = false,length = 40)
    private String typeAccountBanking;
    @Column(name = "amountAccountBanking",nullable = false,length = 40)
    private double amountAccountBanking;
    @Column(name = "dateOpening",nullable = false,length = 40)
    private LocalDate dateOpening;

    @ManyToOne
    @JoinColumn(name = "idBankingEntity")
    private BankingEntity entityBank;

    public AccountBanking() {
    }

    public AccountBanking(int numberAccountBanking, String typeAccountBanking, double amountAccountBanking, LocalDate dateOpening, BankingEntity entityBank) {
        this.numberAccountBanking = numberAccountBanking;
        this.typeAccountBanking = typeAccountBanking;
        this.amountAccountBanking = amountAccountBanking;
        this.dateOpening = dateOpening;
        this.entityBank = entityBank;
    }

    public int getNumberAccountBanking() {
        return numberAccountBanking;
    }

    public void setNumberAccountBanking(int numberAccountBanking) {
        this.numberAccountBanking = numberAccountBanking;
    }

    public String getTypeAccountBanking() {
        return typeAccountBanking;
    }

    public void setTypeAccountBanking(String typeAccountBanking) {
        this.typeAccountBanking = typeAccountBanking;
    }

    public double getAmountAccountBanking() {
        return amountAccountBanking;
    }

    public void setAmountAccountBanking(double amountAccountBanking) {
        this.amountAccountBanking = amountAccountBanking;
    }

    public LocalDate getDateOpening() {
        return dateOpening;
    }

    public void setDateOpening(LocalDate dateOpening) {
        this.dateOpening = dateOpening;
    }

    public BankingEntity getEntityBank() {
        return entityBank;
    }

    public void setEntityBank(BankingEntity entityBank) {
        this.entityBank = entityBank;
    }
}
