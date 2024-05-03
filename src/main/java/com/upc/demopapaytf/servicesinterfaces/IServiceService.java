package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.Services;

import java.util.List;

public interface IServiceService {
    public void insert(Services ser);
    public List<Services> list();
    public void delete(int id);
    public Services lisId(int id);


    public List<Services>findbynameandDescription(String name, String descrip);
    public List<String[]> quantityServicebyDateService();
    public List<String[]> quantityServicebyName();
}