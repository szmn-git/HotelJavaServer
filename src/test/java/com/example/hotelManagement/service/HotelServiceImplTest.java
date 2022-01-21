package com.example.hotelManagement.service;

import com.example.hotelManagement.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;


class HotelServiceImplTest {

    private static User testUser1;
    private HotelService mockHotelService;

    @BeforeEach
    void setUp() {

        mockHotelService = mock(HotelService.class);

        testUser1 = new User();
        testUser1.setUserId((long) 1);
        testUser1.setPhoneNumber(123123123);
        testUser1.setPassword("alamakota");

        when(mockHotelService.validateUser(anyInt(),anyString())).thenReturn("WRONG");
        when(mockHotelService.validateUser(anyInt(),eq(testUser1.getPassword()))).thenReturn("NULL");
        when(mockHotelService.validateUser(testUser1.getPhoneNumber(),testUser1.getPassword())).thenReturn("OK");

    }

    @Test
    void validateUserOK() {
        String isOK = "OK";
        String testedString = mockHotelService.validateUser(123123123, "alamakota");
        assertNotNull(testedString);
        assertEquals(isOK, testedString);
    }

    @Test
    void validateUserNULL() {
        String isNULL = "NULL";
        String testedString = mockHotelService.validateUser(125633890, "alamakota");
        assertNotNull(testedString);
        assertEquals(isNULL, testedString);
    }

    @Test
    void validateUserWRONG() {
        String isWRONG = "WRONG";
        String testedString = mockHotelService.validateUser(123123123, "alamapsa");
        assertNotNull(testedString);
        assertEquals(isWRONG, testedString);
    }
}
