package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "BankingEntity")
public class BankingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBankingEntity;
    @Column(name = "nameBankingEntity",nullable = false,length = 40)
    private String nameBankingEntity;
    @Column(name = "descriptionBankingEntity",nullable = false,length = 40)
    private String descriptionBankingEntity;
    @Column(name = "addressBankingEntity",nullable = false,length = 40)
    private String addressBankingEntity;
    @Column(name = "cellphoneBankingEntity",nullable = false,length = 40)
    private String cellphoneBankingEntity;
    @Column(name = "websiteBankingEntity",nullable = false,length = 40)
    private String websiteBankingEntity;
    @Column(name = "headquarterBankingEntity",nullable = false,length = 40)
    private String headquarterBankingEntity;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users user;

    public BankingEntity() {
    }

    public BankingEntity(int idBankingEntity, String nameBankingEntity, String descriptionBankingEntity, String addressBankingEntity, String cellphoneBankingEntity, String websiteBankingEntity, String headquarterBankingEntity, Users user) {
        this.idBankingEntity = idBankingEntity;
        this.nameBankingEntity = nameBankingEntity;
        this.descriptionBankingEntity = descriptionBankingEntity;
        this.addressBankingEntity = addressBankingEntity;
        this.cellphoneBankingEntity = cellphoneBankingEntity;
        this.websiteBankingEntity = websiteBankingEntity;
        this.headquarterBankingEntity = headquarterBankingEntity;
        this.user = user;
    }

    public int getIdBankingEntity() {
        return idBankingEntity;
    }

    public void setIdBankingEntity(int idBankingEntity) {
        this.idBankingEntity = idBankingEntity;
    }

    public String getNameBankingEntity() {
        return nameBankingEntity;
    }

    public void setNameBankingEntity(String nameBankingEntity) {
        this.nameBankingEntity = nameBankingEntity;
    }

    public String getDescriptionBankingEntity() {
        return descriptionBankingEntity;
    }

    public void setDescriptionBankingEntity(String descriptionBankingEntity) {
        this.descriptionBankingEntity = descriptionBankingEntity;
    }

    public String getAddressBankingEntity() {
        return addressBankingEntity;
    }

    public void setAddressBankingEntity(String addressBankingEntity) {
        this.addressBankingEntity = addressBankingEntity;
    }

    public String getCellphoneBankingEntity() {
        return cellphoneBankingEntity;
    }

    public void setCellphoneBankingEntity(String cellphoneBankingEntity) {
        this.cellphoneBankingEntity = cellphoneBankingEntity;
    }

    public String getWebsiteBankingEntity() {
        return websiteBankingEntity;
    }

    public void setWebsiteBankingEntity(String websiteBankingEntity) {
        this.websiteBankingEntity = websiteBankingEntity;
    }

    public String getHeadquarterBankingEntity() {
        return headquarterBankingEntity;
    }

    public void setHeadquarterBankingEntity(String headquarterBankingEntity) {
        this.headquarterBankingEntity = headquarterBankingEntity;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
