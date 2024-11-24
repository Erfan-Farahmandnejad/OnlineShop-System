package com.example.model.Stuff;

import com.example.model.UserModelFacilities.IdiscountModel;

public class PenModel extends StationeryModel implements IdiscountModel {
    private double discountPercent;
    private final String color;

    public PenModel(String stuffName, double stuffPrice, int stuffInventory, String madeCountry, String color) {
        super(stuffName, stuffPrice, stuffInventory, madeCountry);
        this.color = color;

    }
    public String getColor() {
        return color;
    }

    @Override
    public void setDiscount(double percent) {
        this.setStuffPrice(this.getStuffPrice()-(this.getStuffPrice()*(percent/100)));
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:Pen " +
                "color='" + color + '\''
                ;
    }
}
