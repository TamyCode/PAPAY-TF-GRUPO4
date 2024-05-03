package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.BankingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBankingEntityRepository extends JpaRepository<BankingEntity,Integer> {
    @Query(value = "SELECT b.name_banking_entity as NameBankingEntity,count(*)as quantityUsuarios \n" +
            "FROM banking_entity b inner join users u \n" +
            "on b.id_user=u.id_user \n" +
            "GROUP BY b.name_banking_entity ",nativeQuery = true)
    public List<String[]> quantityUserbyBankingEntity();
}