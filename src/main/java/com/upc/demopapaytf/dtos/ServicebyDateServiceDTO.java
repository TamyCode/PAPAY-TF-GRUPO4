package com.upc.demopapaytf.dtos;

import java.time.LocalDate;

public class ServicebyDateServiceDTO {
    private String nameService;
    private LocalDate dateService;
    private float QuantityDateService;

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public LocalDate getDateService() {
        return dateService;
    }

    public void setDateService(LocalDate dateService) {
        this.dateService = dateService;
    }

    public float getQuantityDateService() {
        return QuantityDateService;
    }

    public void setQuantityDateService(float quantityDateService) {
        QuantityDateService = quantityDateService;
    }
}
