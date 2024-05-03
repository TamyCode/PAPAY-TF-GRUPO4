package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.BankingEntity;
import com.upc.demopapaytf.repositories.IBankingEntityRepository;
import com.upc.demopapaytf.servicesinterfaces.IBankingEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingEntityServiceImplement implements IBankingEntityService {
    @Autowired
    private IBankingEntityRepository bR;
    @Override
    public void insert(BankingEntity bankingEntity) {
        bR.save(bankingEntity);
    }

    @Override
    public List<BankingEntity> list() {
        return bR.findAll();
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public BankingEntity lisId(int id) {
        return bR.findById(id).orElse(new BankingEntity());
    }

    @Override
    public List<String[]> quantityUserbyBankingEntity() {
        return bR.quantityUserbyBankingEntity();
    }
}
