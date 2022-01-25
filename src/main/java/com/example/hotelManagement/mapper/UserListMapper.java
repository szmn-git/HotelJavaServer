package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.UserDto;
import com.example.hotelManagement.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserListMapper {

    public List<UserDto> mapToDto(List<User> users){
        List<UserDto> usersDto = new ArrayList<>();

        for(User user: users){
            UserDto userDto = new UserDto();

            userDto.setUserId(user.getUserId());
            userDto.setNumberPhone(user.getPhoneNumber());
            userDto.setPassword(user.getPassword());

            usersDto.add(userDto);
        }

        return usersDto;
    }
}
