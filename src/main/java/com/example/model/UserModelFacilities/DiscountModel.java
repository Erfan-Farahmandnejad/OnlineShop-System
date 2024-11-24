package com.example.model.UserModelFacilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DiscountModel {
    private double discountPercent;
    private LocalDate discountExpiration;
    private int discountCapacity;
    private String discountCode;


    public DiscountModel(double discountPercent ,String date,int discountCapacity) {
        this.discountPercent = discountPercent;
        this.discountCapacity = discountCapacity;
        this.createDiscountCode();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.discountExpiration=LocalDate.parse(date,formatter);

    }

    public double getDiscountPercent() {
        return this.discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getDiscountExpiration() {
        return this.discountExpiration;
    }

    public void setDiscountExpiration(LocalDate discountExpiration) {
        this.discountExpiration = discountExpiration;
    }

    public int getDiscountCapacity() {
        return this.discountCapacity;
    }

    public void setDiscountCapacity(int discountCapacity) {
        this.discountCapacity = discountCapacity;
    }

    public String getDiscountCode() {
        return this.discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public void createDiscountCode() {
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();

        for(int counter = 0; counter<8; counter++) {
            int choose = rand.nextInt(1, 4);
            int number;
            if (choose == 1) {
                number = rand.nextInt(65, 91);
                stringBuilder.append((char)number);
            }

            if (choose == 2) {
                number = rand.nextInt(97, 123);
                stringBuilder.append((char)number);
            }

            if (choose == 3) {
                number = rand.nextInt(0, 9);
                stringBuilder.append(number);
            }
        }

        this.setDiscountCode(stringBuilder.toString());
    }
    //-------------------------------------------------------------------------

    @Override
    public String toString() {
        return
                "discountPercent=" + discountPercent +
                "   discountExpiration=" + discountExpiration +
                "   discountCapacity=" + discountCapacity +
                "   discountCode='" + discountCode ;
    }
}
