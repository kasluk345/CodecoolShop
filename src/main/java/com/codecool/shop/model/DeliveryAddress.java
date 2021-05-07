package com.codecool.shop.model;

import java.time.LocalDateTime;

public class DeliveryAddress {
    private String id;
    private LocalDateTime localDateTime;
    private String firstName;
    private String surname;
    private String streetName;
    private int houseNumber;
    private int apartmentNumber;
    private String postcode;
    private String cityName;

    public DeliveryAddress(String firstName, String surname, String streetName, int houseNumber, int apartmentNumber, String postcode, String cityName) {
        this.firstName = firstName;
        this.surname = surname;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.postcode = postcode;
        this.cityName = cityName;
    }

    public DeliveryAddress(LocalDateTime localDateTime){
        this.localDateTime = localDateTime;
    }
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", postcode='" + postcode + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
