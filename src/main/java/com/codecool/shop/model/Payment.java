package com.codecool.shop.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Payment {
    private String id;
    private LocalDateTime localDateTime;
    private String type;
    private String cardNumber;
    private String expirationDate;
    private String cardholderName;


    public Payment(String type, String cardNumber, String expirationDate, String cardholderName) {
        this.type = type;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardholderName = cardholderName;
    }

    public Payment(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


