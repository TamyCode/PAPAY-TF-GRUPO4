package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.BankingEntity;

import java.time.LocalDate;
import java.util.Date;

public class AccountBankingDTO {
    private int numberAccountBanking;
    private String typeAccountBanking;
    private double amountAccountBanking;
    private LocalDate dateOpening;
    private BankingEntity entityBank;

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
