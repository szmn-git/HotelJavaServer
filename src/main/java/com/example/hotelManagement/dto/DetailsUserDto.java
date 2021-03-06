package com.example.hotelManagement.dto;

public class DetailsUserDto {
    private Long userId;
    private int numberPhone;
    private String password;

    public DetailsUserDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
                "userId=" + userId +
                ", numberPhone=" + numberPhone +
                ", password='" + password + '\'' +
                '}';
    }
}
