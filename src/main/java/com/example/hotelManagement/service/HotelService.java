package com.example.hotelManagement.service;

import com.example.hotelManagement.dto.CreateUserDto;
import com.example.hotelManagement.dto.DetailsUserDto;

import java.awt.*;

public interface HotelService {
    void createUser(CreateUserDto createUserDto);

    List<DetailsUserDto> getUsers();
}
