package com.example.hotelManagement.dto;

public class CreateUserDto {
    private int numberPhone;
    private String password;

    public CreateUserDto() {
    }

    public CreateUserDto(int numberPhone, String password) {
        this.numberPhone = numberPhone;
        this.password = password;
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

    @Override
    public String toString() {
        return "DetailsUserDto{" +
                "numberPhone=" + numberPhone +
                ", password='" + password + '\'' +
                '}';
    }
}
