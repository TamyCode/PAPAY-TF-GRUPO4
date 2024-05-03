package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users user);
    public List<Users> list();
    public void delete(int id);
    public Users lisId(int id);

    public List<Users> findByLastnameUser(String lastname);
    public List<String[]> quantyAgesByUser();
    public List<String[]> quantyCityByUser();
}