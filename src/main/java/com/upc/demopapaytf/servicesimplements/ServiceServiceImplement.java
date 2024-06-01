package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.Role;
import com.upc.demopapaytf.entities.Services;
import com.upc.demopapaytf.repositories.IServiceRepository;
import com.upc.demopapaytf.servicesinterfaces.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImplement implements IServiceService {
    @Autowired
    private IServiceRepository sR;

    @Override
    public void insert(Services ser) {
        sR.save(ser);
    }

    @Override
    public List<Services> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        {
            sR.deleteById(id);
        }
    }

    @Override
    public Services lisId(int id){return sR.findById(id).orElse(new Services());}

    @Override
    public List<Services> findbynameandDescription(String name, String descrip) {
        return sR.findByNameServiceAndDescriptionService(name,descrip);
    }

    @Override
    public List<String[]> quantityServicebyDateService() {
        return sR.quantityServicebyDateService();
    }

    @Override
    public List<String[]> quantityServicebyName() {
        return sR.quantityServicebyName();
    }

}
