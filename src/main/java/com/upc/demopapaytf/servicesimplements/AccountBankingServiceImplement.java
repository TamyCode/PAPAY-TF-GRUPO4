package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.AccountBanking;
import com.upc.demopapaytf.repositories.IAccountBankingRepository;
import com.upc.demopapaytf.servicesinterfaces.IAccountBankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBankingServiceImplement implements IAccountBankingService {
    @Autowired
    private IAccountBankingRepository aR;
    @Override
    public void insert(AccountBanking accountBanking) {aR.save(accountBanking);}

    @Override
    public List<AccountBanking> list() {return aR.findAll();}

    @Override
    public void delete(int id) {aR.deleteById(id);}

    @Override
    public AccountBanking lisId(int id) {return aR.findById(id).orElse(new AccountBanking());}

    @Override
    public List<String[]> quantyAccountBankingByType() {
        return aR.quantyAccountBankingByType();
    }
}
