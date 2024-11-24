package com.example.model.Stuff;

public abstract class StorageEquipmentModel extends DigitalStuffModel {
    private final double capacity;

    public StorageEquipmentModel(String stuffName, double stuffPrice, int stuffInventory, double weight, String girth, double capacity) {
        super(stuffName, stuffPrice, stuffInventory, weight, girth);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return super.toString()+
                "capacity=" + capacity
                ;
    }
}
