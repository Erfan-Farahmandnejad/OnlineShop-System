package com.example.model.Stuff;

import com.example.model.UserModelFacilities.IdiscountModel;

public class PencilModel extends StationeryModel implements IdiscountModel {
    private double discountPercent;
    private final PencilKindModel pencilKindModel;

    public PencilModel(String stuffName, double stuffPrice, int stuffInventory, String madeCountry, PencilKindModel pencilKindModel) {
        super(stuffName, stuffPrice, stuffInventory, madeCountry);
        this.pencilKindModel = pencilKindModel;

    }
    public PencilKindModel getPencilKindModel() {
        return pencilKindModel;
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
        return super.toString()+" Stuff type:Pencil " +
                "pencilKindModel=" + pencilKindModel
                ;
    }
}
