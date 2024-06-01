package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="TypeService" )
public class TypeService {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeService;
    @Column(name = "nameTypeService",nullable = false,length = 40)
    private String nameTypeService;

    public TypeService() {
    }

    public TypeService(int idTypeService, String nameTypeService) {
        this.idTypeService = idTypeService;
        this.nameTypeService = nameTypeService;

    }

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getNameTypeService() {
        return nameTypeService;
    }

    public void setNameTypeService(String nameTypeService) {
        this.nameTypeService = nameTypeService;
    }

}
