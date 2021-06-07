package com.example.hotelManagement.repository;

import com.example.hotelManagement.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

    List<User> findByOrder();

    /* Delete user
    @Modifying
    @Query("DELETE FROM User u WHERE u.userId = :userId")
    void deleteById(@Param("userId") Long userId); */

    User findOneByUserId(Long userId);

}
