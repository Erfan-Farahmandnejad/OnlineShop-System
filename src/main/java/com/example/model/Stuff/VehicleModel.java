package com.example.model.Stuff;

public abstract class VehicleModel extends StuffModel {
    private final String companyName;
    public VehicleModel(String stuffName, double stuffPrice, int stuffInventory, String companyName)
    {
        super(stuffName, stuffPrice, stuffInventory, StuffKindModel.VEHICLE);
        this.companyName=companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public String toString() {
        return super.toString()+
                " companyName='" + companyName + '\''
                ;
    }
}
