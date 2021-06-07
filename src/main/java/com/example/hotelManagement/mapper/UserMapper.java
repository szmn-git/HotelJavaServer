package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.CreateUserDto;
import com.example.hotelManagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEnitity(CreateUserDto createUserDto){
        User user = new User();

        user.setUserId(createUserDto.getUserId());
        user.setPhoneNumber(createUserDto.getNumberPhone());
        user.setPassword(createUserDto.getPassword());

        return user;
    }
}
