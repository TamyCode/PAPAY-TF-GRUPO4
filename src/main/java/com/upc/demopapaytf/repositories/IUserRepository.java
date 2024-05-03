package com.upc.demopapaytf.repositories;

import com.upc.demopapaytf.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users,Integer> {
    public Users findByNameUser(String username);
    public List<Users> findByLastnameUser(String lastname);

    //BUSCAR POR NOMBRE
    @Query("select count(u.nameUser) from Users u where u.nameUser =:username")
    public int buscarUsername(@Param("username") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") int user_id);


    //
    @Query(value = "SELECT age_user as AGE,count(*)as CANTIDAD \n" +
            "FROM users  \n" +
            "GROUP BY age_user ",nativeQuery = true)
    public List<String[]> quantyAgesByUser();

    @Query(value = "SELECT city_user as CITYUSER,count(*)as quantity \n" +
            "    FROM users \n" +
            "    GROUP BY city_user",nativeQuery = true)
    public List<String[]> quantyCityByUser();
}
