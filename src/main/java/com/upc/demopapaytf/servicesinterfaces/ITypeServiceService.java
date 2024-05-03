package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.TypeService;

import java.util.List;

public interface ITypeServiceService {
    public void insert(TypeService typeService);
    public List<TypeService> list();
    public void delete(int id);
    public TypeService lisId(int id);

    public List<TypeService> findTypeServicesByNameTypeService(String typeName);
}
