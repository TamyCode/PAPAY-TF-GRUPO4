package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.AccountBanking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountBankingRepository extends JpaRepository<AccountBanking,Integer> {
    @Query(value = "SELECT type_account_banking as TYPEACCOUNTBANKING,count(*)as quantity \n" +
            "FROM account_banking \n" +
            "GROUP BY type_account_banking",nativeQuery = true)

    public List<String[]> quantyAccountBankingByType();
}
