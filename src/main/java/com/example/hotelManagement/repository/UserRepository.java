package com.example.hotelManagement.repository;

import com.example.hotelManagement.dto.DetailsUserDto;
import com.example.hotelManagement.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

    List<User> findByOrderByUserIdDesc();

    User findByPhoneNumberIs(Integer phoneNumber);

    // Delete user
    void deleteById(Long userId);

}
