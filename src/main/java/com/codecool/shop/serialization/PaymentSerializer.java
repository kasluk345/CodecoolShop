package com.codecool.shop.serialization;

import com.codecool.shop.model.Payment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PaymentSerializer {
    public Payment mapFromParams(String body) {

        String[] fields = body.split("&");
        String type = fields[0].split("=")[1];
        String cardNumber = fields[1].split("=")[1];
        String expirationDate = fields[1].split("=")[1];
        SimpleDateFormat sdf = new SimpleDateFormat("M/yyyy");
        String cardholderName = fields[0].split("=")[1];

        return new Payment(type, cardNumber, expirationDate, cardholderName);
    }
}
