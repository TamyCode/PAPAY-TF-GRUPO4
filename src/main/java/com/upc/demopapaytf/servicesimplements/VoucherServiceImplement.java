package com.upc.demopapaytf.servicesimplements;

import com.upc.demopapaytf.entities.Voucher;
import com.upc.demopapaytf.repositories.IVoucherRepository;
import com.upc.demopapaytf.servicesinterfaces.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoucherServiceImplement implements IVoucherService {
    @Autowired
    private IVoucherRepository vR;
    @Override
    public void insert(Voucher voucher) {
        vR.save(voucher);
    }

    @Override
    public List<Voucher> list() {
        return vR.findAll();
    }

    @Override
    public void delete(int id) {
        vR.deleteById(id);
    }

    @Override
    public Voucher lisId(int id) {
        return vR.findById(id).orElse(new Voucher());
    }

    @Override
    public List<String[]> quantityAmountVoucherService() {
        return vR.quantityAmountVoucherService();
    }
}

