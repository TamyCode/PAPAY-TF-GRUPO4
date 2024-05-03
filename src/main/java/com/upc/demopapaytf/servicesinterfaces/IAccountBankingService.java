package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.AccountBanking;

import java.util.List;

public interface IAccountBankingService {
    public void insert(AccountBanking accountBanking);
    public List<AccountBanking> list();
    public void delete(int id);
    public AccountBanking lisId(int id);

    public List<String[]> quantyAccountBankingByType();
}
