package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher,Integer> {
    @Query(value = "SELECT s.name_service, SUM(v.amount_voucher) AS totalAmount\n" +
            "FROM services s\n" +
            "LEFT JOIN voucher v ON s.id_service = v.id_serviceb\n" +
            "GROUP BY s.name_service",nativeQuery = true)
    public List<String[]> quantityAmountVoucherService();

}
