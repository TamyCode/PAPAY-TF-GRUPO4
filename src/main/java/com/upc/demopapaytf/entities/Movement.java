package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Movement")
public class Movement {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idMovement;
    @Column(name = "dateMovement",nullable = false)
    private Date dateMovement;
    @Column(name = "typeMovement",nullable = false,length = 40)
    private String typeMovement;
    @Column(name = "amountMovement",nullable = false)
    private double amountMovement;

    @ManyToOne
    @JoinColumn(name = "numberAccountBanking")
    private AccountBanking bankingAccount;

    public Movement() {
    }

    public Movement(int idMovement, Date dateMovement, String typeMovement, double amountMovement, AccountBanking bankingAccount) {
        this.idMovement = idMovement;
        this.dateMovement = dateMovement;
        this.typeMovement = typeMovement;
        this.amountMovement = amountMovement;
        this.bankingAccount = bankingAccount;
    }

    public int getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(int idMovement) {
        this.idMovement = idMovement;
    }

    public Date getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(Date dateMovement) {
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
