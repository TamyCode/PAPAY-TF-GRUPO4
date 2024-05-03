package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.Role;

import java.util.List;

public interface IRoleService {
    public void insert(Role role);
    public List<Role> list();
    public void delete(int id);
    public Role lisId(int id);
}
