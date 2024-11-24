package com.example.model.Stuff;

public class BicycleModel extends VehicleModel {
    private final BicycleKindModel bicycleKindModel;

    public BicycleModel(String stuffName, double stuffPrice, int stuffInventory, String companyName, BicycleKindModel bicycleKindModel) {
        super(stuffName, stuffPrice, stuffInventory, companyName);
        this.bicycleKindModel = bicycleKindModel;
    }

    public BicycleKindModel getBicycleKindModel() {
        return bicycleKindModel;
    }

    @Override
    public String toString() {
        return super.toString()+" StuffType:Bicycle " +
                "bicycleKindModel=" + bicycleKindModel
                ;
    }
}
