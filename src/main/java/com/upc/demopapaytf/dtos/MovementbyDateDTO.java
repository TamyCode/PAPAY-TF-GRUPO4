package com.upc.demopapaytf.dtos;

import java.time.LocalDate;

public class MovementbyDateDTO {
    private int movementId;
    private LocalDate dateMovement;
    private int quantityMovement;

    public int getMovementId() {
        return movementId;
    }

    public void setMovementId(int movementId) {
        this.movementId = movementId;
    }

    public LocalDate getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(LocalDate dateMovement) {
        this.dateMovement = dateMovement;
    }

    public int getQuantityMovement() {
        return quantityMovement;
    }

    public void setQuantityMovement(int quantityMovement) {
        this.quantityMovement = quantityMovement;
    }
}
