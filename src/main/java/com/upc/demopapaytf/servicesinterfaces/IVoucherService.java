package com.upc.demopapaytf.servicesinterfaces;

import com.upc.demopapaytf.entities.Voucher;

import java.util.List;

public interface IVoucherService {
    public void insert(Voucher voucher);
    public List<Voucher> list();
    public void delete(int id);
    public Voucher lisId(int id);

    public List<String[]>quantityAmountVoucherService();
}