package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.Movement;

import java.util.List;

public interface IMovementService {
    public void insert(Movement movement);
    public List<Movement> list();
    public void delete(int id);
    public Movement lisId(int id);
    public List<String[]> MoneyInvestedbyAccountBanking();

    public List<String[]> quantityMovementbyDate();

}