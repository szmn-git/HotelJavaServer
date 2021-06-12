package com.example.hotelManagement.service;

import com.example.hotelManagement.dto.CreateUserDto;
import com.example.hotelManagement.dto.DetailsUserDto;
import com.example.hotelManagement.dto.UserDto;
import com.example.hotelManagement.entity.User;
import com.example.hotelManagement.mapper.UserDetailsMapper;
import com.example.hotelManagement.mapper.UserListMapper;
import com.example.hotelManagement.mapper.UserMapper;
import com.example.hotelManagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
public class HotelServieImpl implements HotelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelServieImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserListMapper userListMapper;
    private final UserDetailsMapper userDetailsMapper;

    @Autowired
    public HotelServieImpl(UserRepository userRepository, UserMapper userMapper, UserListMapper userListMapper, UserDetailsMapper userDetailsMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userListMapper = userListMapper;
        this.userDetailsMapper = userDetailsMapper;
    }

    // Find all users
    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findByOrderByUserIdDesc();
        return userListMapper.mapToDto(users);
    }

    //Create new user
    @Override
    public void createUser(CreateUserDto createUserDto) {
        User user = userMapper.mapToEnitity(createUserDto);
        userRepository.save(user);
    }

    @Override
    public DetailsUserDto findUser(Long userId) {
        User user = userRepository.getOne(userId);

        return userDetailsMapper.mapToDto(user);
    }

    // Find user by phone number
    /*
    @Override
    public DetailsUserDto findByPhone(Integer phoneNumber) {
        User user = userRepository.findByPhoneNumberIs(phoneNumber);
        return userDetailsMapper.mapToDto(user);
    }
     */

    @Override
    public String validateUser(Integer phoneNumber, String password) {
        String isValidate;
        //search database by number
        User user = userRepository.findByPhoneNumberIs(phoneNumber);
        if(user == null) {
            isValidate = "NO ACC";
        }
        else if(user.getPassword().equals(password)) {
            isValidate = "OK";
        }
        else {
            isValidate = "WRONG PASSWORD";
        }
        return isValidate;
    }

}
