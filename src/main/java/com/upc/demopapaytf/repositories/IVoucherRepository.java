package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher,Integer> {
    @Query(value = "select s.name_service as servicio, sum (v.amount_voucher) as voucher \n" +
            "from services s \n" +
            "inner join voucher v on s.id_service=v.id_voucher \n" +
            "group by s.name_service",nativeQuery = true)
    public List<String[]> findByAmountVoucherService();
}
