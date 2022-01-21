package com.example.hotelManagement.repository;

import com.example.hotelManagement.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserRepositoryTest {

    private static UserRepository mockUserRepository;
    private static User testUser1;
    private static User testUser2;
    private List<User> testList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        mockUserRepository = mock(UserRepository.class);

        testUser1 = new User();
        testUser1.setUserId((long) 1);
        testUser1.setPhoneNumber(123123123);
        testUser1.setPassword("alamakota");

        testUser2 = new User();
        testUser2.setUserId((long) 1);
        testUser2.setPhoneNumber(123123123);
        testUser2.setPassword("alamakota");

        testList.add(testUser1);
        testList.add(testUser2);

        when(mockUserRepository.findByPhoneNumberIs(testUser1.getPhoneNumber())).thenReturn(testUser1);
        when(mockUserRepository.findByOrderByUserIdDesc()).thenReturn(testList);
    }

    @Test
    void findByOrderByUserIdDesc() {
        List<User> users = mockUserRepository.findByOrderByUserIdDesc();
            // tested List isn't empty
        assertNotNull(users);
            // tested List should have size of 2 test users
        assertEquals(2, users.size());
            // first user of tested List should be 'testUser1'
        assertEquals(testUser1, users.get(0));
    }

    @Test
    void findByPhoneNumberIsOK() {
        User testUser = mockUserRepository.findByPhoneNumberIs(123123123);
        assertNotNull(testUser);
        assertEquals(Long.valueOf(1), testUser.getUserId());
        assertEquals("alamakota", testUser.getPassword());
    }

    @Test
    void findByPhoneNumberIsWrongTest() {
        User testUser = mockUserRepository.findByPhoneNumberIs(999999999);
            // testUser doesn't exist - should be null
        assertNull(testUser);
    }
}
