package com.example.hotelManagement.controller;

import com.example.hotelManagement.dto.CreateUserDto;
import com.example.hotelManagement.dto.DetailsUserDto;
import com.example.hotelManagement.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@Controller
@RequestMapping(value = "/api")
public class HotelApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HotelApiController.class);

    private final HotelService hotelService;

    @Autowired
    public HotelApiController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Show all users
    @CrossOrigin
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<DetailsUserDto>> getUsers(){
        LOGGER.info("Find all users");

        List<DetailsUserDto> userDtoList = hotelService.getUsers();
        return new ResponseEntity<>(HttpStatus.OK); // detailsUserDto,HttpStatus.OK
    }

    // Create new user
    @CrossOrigin
    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto createUserDto){
        LOGGER.info("create user: {}",createUserDto);

        hotelService.createUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
