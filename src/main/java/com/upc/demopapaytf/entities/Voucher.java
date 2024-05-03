package com.upc.demopapaytf.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVoucher;
    @Column(name = "dateVoucher",nullable = false)
    private LocalDate dateVoucher;
    @Column(name = "hourVoucher",nullable = false)
    private LocalDateTime hourVoucher;
    @Column(name = "destinationAccountVoucher",nullable = false)
    private int destinationAccountVoucher;
    @Column(name = "amountVoucher",nullable = false)
    private double amountVoucher;
    @Column(name = "numberOperationVoucher",nullable = false)
    private int numberOperationVoucher;
    //@ManyToOne
    @OneToOne
    @JoinColumn(name = "idServiceB")
    private Services serviceB;

    public Voucher() {
    }

    public Voucher(int idVoucher, LocalDate dateVoucher, LocalDateTime hourVoucher, int destinationAccountVoucher, double amountVoucher, int numberOperationVoucher, Services serviceB) {
        this.idVoucher = idVoucher;
        this.dateVoucher = dateVoucher;
        this.hourVoucher = hourVoucher;
        this.destinationAccountVoucher = destinationAccountVoucher;
        this.amountVoucher = amountVoucher;
        this.numberOperationVoucher = numberOperationVoucher;
        this.serviceB = serviceB;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public LocalDate getDateVoucher() {
        return dateVoucher;
    }

    public void setDateVoucher(LocalDate dateVoucher) {
        this.dateVoucher = dateVoucher;
    }

    public LocalDateTime getHourVoucher() {
        return hourVoucher;
    }

    public void setHourVoucher(LocalDateTime hourVoucher) {
        this.hourVoucher = hourVoucher;
    }

    public int getDestinationAccountVoucher() {
        return destinationAccountVoucher;
    }

    public void setDestinationAccountVoucher(int destinationAccountVoucher) {
        this.destinationAccountVoucher = destinationAccountVoucher;
    }

    public double getAmountVoucher() {
        return amountVoucher;
    }

    public void setAmountVoucher(double amountVoucher) {
        this.amountVoucher = amountVoucher;
    }

    public int getNumberOperationVoucher() {
        return numberOperationVoucher;
    }

    public void setNumberOperationVoucher(int numberOperationVoucher) {
        this.numberOperationVoucher = numberOperationVoucher;
    }

    public Services getServiceB() {
        return serviceB;
    }

    public void setServiceB(Services serviceB) {
        this.serviceB = serviceB;
    }
}
