package com.example.model.Stuff;

import com.example.model.UserModelFacilities.IdiscountModel;

public abstract class DigitalStuffModel extends StuffModel implements IdiscountModel {
    private Double discountPercent;
    private final double weight;
    private final String girth;
    public DigitalStuffModel(String stuffName, double stuffPrice, int stuffInventory, double weight, String girth)
    {   super(stuffName, stuffPrice, stuffInventory, StuffKindModel.DIGITALSTUFF);
        this.weight=weight;
        this.girth=girth;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getGirth() {
        return this.girth;
    }

    @Override
    public void setDiscount(double percent) {
      this.setStuffPrice(this.getStuffPrice()-(this.getStuffPrice()*(percent/100)));
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return super.toString()+
                " weight=" + weight +
                ", girth='" + girth + '\''
                ;
    }
}

