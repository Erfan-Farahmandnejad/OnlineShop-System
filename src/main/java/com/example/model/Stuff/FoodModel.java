package com.example.model.Stuff;

public class FoodModel extends StuffModel {
    private final String productionDate;
    private final String expirationDate;
    public FoodModel(String stuffName, double stuffPrice, int stuffInventory, String productionDate, String expirationDate)
    {
        super(stuffName, stuffPrice, stuffInventory, StuffKindModel.FOOD);
        this.productionDate=productionDate;
        this.expirationDate=expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getProductionDate() {
        return productionDate;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:Food " +
                "productionDate='" + productionDate + '\'' +
                ", expirationDate='" + expirationDate + '\''
                ;
    }
}
