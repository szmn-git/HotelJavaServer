package com.example.hotelManagement.dto;

public class CreateUserDto {
    private Long userId;
    private int numberPhone;
    private String password;

    public CreateUserDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "CreateUserDto{" +
                "userId=" + userId +
                ", numberPhone=" + numberPhone +
                ", password='" + password + '\'' +
                '}';
    }
}
