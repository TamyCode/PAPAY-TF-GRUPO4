package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.Users;

public class BankingEntityDTO {
    private int idBankingEntity;
    private String nameBankingEntity;
    private String descriptionBankingEntity;
    private String addressBankingEntity;
    private String cellphoneBankingEntity;
    private String websiteBankingEntity;
    private String headquarterBankingEntity;
    private Users user;

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
