package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.BankingEntity;

import java.util.List;

public interface IBankingEntityService {
    public void insert(BankingEntity bankingEntity);
    public List<BankingEntity> list();
    public void delete(int id);
    public BankingEntity lisId(int id);
    public List<String[]> quantityUserbyBankingEntity();
}
