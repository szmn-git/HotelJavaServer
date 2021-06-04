package com.example.hotelManagement.dto;

public class DetailsUserDto {
    private int numberPhone;
    private String password;

    public DetailsUserDto() {
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
