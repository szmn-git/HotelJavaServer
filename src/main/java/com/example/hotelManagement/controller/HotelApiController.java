package com.example.hotelManagement.controller;

import com.example.hotelManagement.dto.CreateUserDto;
import com.example.hotelManagement.dto.DetailsUserDto;
import com.example.hotelManagement.dto.UserDto;
import com.example.hotelManagement.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/reception/users")
    public ResponseEntity<List<UserDto>> getUsers(){
        LOGGER.info("Find all users");

        List<UserDto> userDtoList = hotelService.findAll();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    // Create new user
    @CrossOrigin
    @PostMapping(value = "/users/add")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDto createUserDto){
        LOGGER.info("create user: {}",createUserDto);

        hotelService.createUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(value = "/reception/user/{userId}")
    public ResponseEntity<DetailsUserDto> detailsUser(@PathVariable Long userId){
        LOGGER.info("details user: {}", userId);

        DetailsUserDto detailsUserDto = hotelService.findUser(userId);
        return new ResponseEntity<>(detailsUserDto, HttpStatus.OK);
    }

    /*
    @CrossOrigin
    @GetMapping(value = "/users/login/{phoneNumber}/{password}")
    public ResponseEntity<DetailsUserDto> phoneUser(@PathVariable Integer phoneNumber){
        LOGGER.info("details user: {}", phoneNumber);

        DetailsUserDto detailsUserDto = hotelService.findByPhone(phoneNumber);
        LOGGER.info("password: {}", detailsUserDto.getPassword());
        return new ResponseEntity<>(detailsUserDto, HttpStatus.OK);
    }
     */

    // Validate user
    @CrossOrigin
    @GetMapping(value = "/login/{phoneNumber}/{password}")
    public ResponseEntity<String> loginUser(@PathVariable Integer phoneNumber, @PathVariable String password){
        LOGGER.info("received phone number: {}", phoneNumber);
        LOGGER.info("received password: {}", password);

        return new ResponseEntity<>((hotelService.validateUser(phoneNumber, password)), HttpStatus.OK);
    }
}
