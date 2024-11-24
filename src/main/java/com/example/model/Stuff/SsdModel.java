package com.example.model.Stuff;

public class SsdModel extends StorageEquipmentModel {
    private final double writeSpeed;
    private final double readSpeed;

    public SsdModel(String stuffName, double stuffPrice, int stuffInventory, double weight, String girth, double capacity, double writeSpeed, double readSpeed) {
        super(stuffName, stuffPrice, stuffInventory, weight, girth, capacity);
        this.writeSpeed = writeSpeed;
        this.readSpeed = readSpeed;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:SsdModel " +
                "writeSpeed=" + writeSpeed +
                ", readSpeed=" + readSpeed
                ;
    }
}