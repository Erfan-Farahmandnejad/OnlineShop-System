package com.example.model.Stuff;

public class PersonalComputerModel extends DigitalStuffModel {
    private final String cpuModel;
    private final int ramCapacity;

    public PersonalComputerModel(String stuffName, double stuffPrice, int stuffInventory, double weight, String girth, String cpuModel, int ramCapacity) {
        super(stuffName, stuffPrice, stuffInventory, weight, girth);
        this.cpuModel = cpuModel;
        this.ramCapacity = ramCapacity;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:PersonalComputer " +
                "cpuModel='" + cpuModel + '\'' +
                ", ramCapacity=" + ramCapacity
                ;
    }
}
