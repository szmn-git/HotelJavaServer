package com.example.hotelManagement.service;

import com.example.hotelManagement.dto.CreateUserDto;
import com.example.hotelManagement.dto.DetailsUserDto;
import com.example.hotelManagement.dto.UserDto;

import java.util.List;

public interface HotelService {

    List<UserDto> findAll();

    void createUser(CreateUserDto createUserDto);

    DetailsUserDto findUser(Long userId);

}
