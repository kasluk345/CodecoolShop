package com.codecool.shop.serialization;

import com.codecool.shop.model.DeliveryAddress;
import com.codecool.shop.model.User;

public class DeliveryAddressSerializer {
    public DeliveryAddress mapFromParams(String body) {

        String[] fields = body.split("&");
        String firstName = fields[0].split("=")[1];
        String surname = fields[1].split("=")[1];
        String streetName = fields[2].split("=")[1];
        int houseNumber = Integer.parseInt(fields[3].split("=")[1]);
        int apartmentNumber = Integer.parseInt(fields[4].split("=")[1]);
        String postcode = fields[5].split("=")[1];
        String cityName = fields[6].split("=")[1];

//        DeliveryAddress deliveryAddress = new DeliveryAddress(firstName, surname, streetName, houseNumber, apartmentNumber, postcode, cityName);
//        System.out.println(deliveryAddress);

        return new DeliveryAddress(firstName, surname, streetName, houseNumber, apartmentNumber, postcode, cityName);
    }
}
