package com.example.model.Stuff;

public abstract class StationeryModel extends StuffModel {
    private final String madeCountry;
        public StationeryModel(String stuffName, double stuffPrice, int stuffInventory, String madeCountry)
    {   super(stuffName, stuffPrice, stuffInventory, StuffKindModel.STATIONERY);
        this.madeCountry=madeCountry;
    }

    public String getMadeCountry() {
        return madeCountry;
    }

    @Override
    public String toString() {
        return super.toString()+
                " madeCountry='" + madeCountry + '\''
                ;
    }
}
