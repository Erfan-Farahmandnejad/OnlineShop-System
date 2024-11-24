package com.example.model.Stuff;

public class CarModel extends VehicleModel {
    private final int engineCapacity;
    private final boolean isAutomatic;

    public CarModel(String stuffName, double stuffPrice, int stuffInventory, String companyName, int engineCapacity, boolean isAutomatic) {
        super(stuffName, stuffPrice, stuffInventory, companyName);
        this.engineCapacity = engineCapacity;
        this.isAutomatic = isAutomatic;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:Car " +
                "engineCapacity=" + engineCapacity +
                ", isAutomatic=" + isAutomatic
                ;
    }
}

