package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovementRepository extends JpaRepository<Movement,Integer> {
    @Query(value = "Select number_account_banking as NumberAccountBanking,sum(amount_movement) as MoneyInvested \n" +
            "from movement \n" +
            "group by number_account_banking ",nativeQuery = true)
    public List<String[]> MoneyInvestedbyAccountBanking();

    @Query(value= "Select id_movement as MovementID , date_movement as DateMovement, count(date_movement) as Quantity  \n" +
            "from movement  \n" +
            "group by id_movement,date_movement ",nativeQuery = true)
    public List<String[]> quantityMovementbyDate();

}