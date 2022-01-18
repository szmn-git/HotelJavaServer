package com.example.hotelManagement.service;

import com.example.hotelManagement.dto.UserDto;
import com.example.hotelManagement.entity.User;
import com.example.hotelManagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceImplTest {

    @InjectMocks
    private HotelServiceImpl hotelService;



    @BeforeEach
    void setUp() {/*
        UserDto testUser = new UserDto();

        testUser.setUserId((long) 1);
        testUser.setNumberPhone(999111000);
        testUser.setPassword("polskagurom");

        users.add(testUser);*/
    }

    @Test
    void findAll() {
        //Assert.assertArrayEquals(hotelService.findAll().toArray(),users.toArray());
    }

    @Test
    void createUser() {
    }

    @Test
    void findUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void validateUser() {
        String isOK = "OK";
        String tested = hotelService.validateUser(999111000,"polskagurom");
        assertEquals(isOK,tested);
    }
}
