package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
