package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.Movement;
import com.upc.demopapaytf.repositories.IMovementRepository;
import com.upc.demopapaytf.servicesinterfaces.IMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementServiceImplement implements IMovementService {
    @Autowired
    private IMovementRepository mR;
    @Override
    public void insert(Movement movement) {
        mR.save(movement);
    }

    @Override
    public List<Movement> list() {
        return mR.findAll();
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public Movement lisId(int id) {
        return mR.findById(id).orElse(new Movement());
    }

    @Override
    public List<String[]> MoneyInvestedbyAccountBanking() {
        return mR.MoneyInvestedbyAccountBanking();
    }

    @Override
    public List<String[]> quantityMovementbyDate() {
        return mR.quantityMovementbyDate();
    }


}