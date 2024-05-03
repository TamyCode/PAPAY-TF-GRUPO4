package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.Users;
import com.upc.demopapaytf.repositories.IUserRepository;
import com.upc.demopapaytf.servicesinterfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements IUserService {
    @Autowired
    private IUserRepository uR;
    @Override
    public void insert(Users user) {
        uR.save(user);
    }

    @Override
    public List<Users> list() {
        return uR.findAll();
    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public Users lisId(int id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public List<Users> findByLastnameUser(String lastname) {
        return uR.findByLastnameUser(lastname);
    }

    @Override
    public List<String[]> quantyAgesByUser() {
        return uR.quantyAgesByUser();
    }

    @Override
    public List<String[]> quantyCityByUser() {
        return uR.quantyCityByUser();
    }

}
