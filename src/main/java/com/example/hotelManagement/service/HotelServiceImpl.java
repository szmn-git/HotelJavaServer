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

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserListMapper userListMapper;
    private final UserDetailsMapper userDetailsMapper;

    @Autowired
    public HotelServiceImpl(UserRepository userRepository, UserMapper userMapper, UserListMapper userListMapper, UserDetailsMapper userDetailsMapper) {
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

    // Find all users
    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

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
