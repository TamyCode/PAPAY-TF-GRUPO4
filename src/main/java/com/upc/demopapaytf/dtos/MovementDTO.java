package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.AccountBanking;

import java.time.LocalDate;
import java.util.Date;

public class MovementDTO {
    private int idMovement;
    private LocalDate dateMovement;
    private String typeMovement;
    private double amountMovement;
    private AccountBanking bankingAccount;

    public int getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(int idMovement) {
        this.idMovement = idMovement;
    }

    public LocalDate getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(LocalDate dateMovement) {
        this.dateMovement = dateMovement;
    }

    public String getTypeMovement() {
        return typeMovement;
    }

    public void setTypeMovement(String typeMovement) {
        this.typeMovement = typeMovement;
    }

    public double getAmountMovement() {
        return amountMovement;
    }

    public void setAmountMovement(double amountMovement) {
        this.amountMovement = amountMovement;
    }

    public AccountBanking getBankingAccount() {
        return bankingAccount;
    }

    public void setBankingAccount(AccountBanking bankingAccount) {
        this.bankingAccount = bankingAccount;
    }
}
