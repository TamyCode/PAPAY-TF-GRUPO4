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

    @ManyToOne
    @JoinColumn(name = "idService")
    private Services service;

    public TypeService() {
    }

    public TypeService(int idTypeService, String nameTypeService, Services service) {
        this.idTypeService = idTypeService;
        this.nameTypeService = nameTypeService;
        this.service = service;
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

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }
}
