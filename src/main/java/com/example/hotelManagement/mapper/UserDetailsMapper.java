package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.DetailsUserDto;
import com.example.hotelManagement.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {

    public DetailsUserDto mapToDto(User user){

        DetailsUserDto detailsUserDto = new DetailsUserDto();

        detailsUserDto.setUserId(user.getUserId());
        detailsUserDto.setNumberPhone(user.getPhoneNumber());
        detailsUserDto.setPassword(user.getPassword());

        return detailsUserDto;
    }
}
