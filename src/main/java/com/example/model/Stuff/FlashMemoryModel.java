package com.example.model.Stuff;

public class FlashMemoryModel extends StorageEquipmentModel {
    private final String usbVersion;

    public FlashMemoryModel(String stuffName, double stuffPrice, int stuffInventory, double weight, String girth, double capacity, String usbVersion) {
        super(stuffName, stuffPrice, stuffInventory, weight, girth, capacity);
        this.usbVersion = usbVersion;
    }

    public String getUsbVersion() {
        return usbVersion;
    }

    @Override
    public String toString() {
        return super.toString()+" Stuff type:FlashMemory " +
                "usbVersion='" + usbVersion + '\''
                ;
    }
}
