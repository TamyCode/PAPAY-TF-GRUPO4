package com.upc.demopapaytf.dtos;

import com.upc.demopapaytf.entities.Services;

public class TypeServiceDTO {
    private int idTypeService;
    private String nameTypeService;

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
