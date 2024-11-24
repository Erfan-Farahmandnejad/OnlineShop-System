package com.example.model.Stuff;

import com.example.model.UserModelFacilities.CommentModel;

import java.util.ArrayList;

public abstract class StuffModel implements Comparable {
    private static int stuffCode = -1;
    private int stuffId = 0;
    private String stuffName;
    private double stuffPrice;
    private int stuffInventory;
    private double averageScore;
    private final StuffKindModel stuffKindModel;
    private ArrayList<CommentModel> stuffComments;

    public StuffModel(String stuffName, double stuffPrice, int stuffInventory, StuffKindModel stuffKindModel) {
        ++stuffCode;
        this.stuffId = stuffCode;
        this.stuffName = stuffName;
        this.stuffKindModel = stuffKindModel;
        this.stuffInventory = stuffInventory;
        this.stuffPrice = stuffPrice;
        this.stuffComments = new ArrayList();
    }

    public ArrayList<CommentModel> getStuffComments() {
        return this.stuffComments;
    }

    public double getAverageScore() {
        return this.averageScore;
    }

    public double getStuffPrice() {
        return this.stuffPrice;
    }

    public static int getStuffCode() {
        return stuffCode;
    }

    public int getStuffInventory() {
        return this.stuffInventory;
    }

    public String getStuffName() {
        return this.stuffName;
    }

    public void setStuffComments(ArrayList<CommentModel> stuffComments) {
        this.stuffComments = stuffComments;
    }

    public void setStuffInventory(int stuffInventory) {
        this.stuffInventory = stuffInventory;
    }

    public void setStuffPrice(double stuffPrice) {
        this.stuffPrice = stuffPrice;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getStuffId() {
        return this.stuffId;
    }

    public StuffKindModel getStuffKindModel() {
        return this.stuffKindModel;
    }

    public void setStuffId(int stuffId) {
        this.stuffId = stuffId;
    }

    public int compareTo(Object o) {
        StuffModel stuffModel = (StuffModel)o;
        int i;
        if (stuffModel.getStuffName().length() <= this.stuffName.length()) {
            for(i = 0; i < stuffModel.stuffName.length(); ++i) {
                if (stuffModel.stuffName.charAt(i) < this.stuffName.charAt(i)) {
                    return 1;
                }

                if (stuffModel.stuffName.charAt(i) > this.stuffName.charAt(i)) {
                    return -1;
                }
            }
        }

        if (stuffModel.getStuffName().length() > this.stuffName.length()) {
            for(i = 0; i < this.stuffName.length(); ++i) {
                if (stuffModel.stuffName.charAt(i) < this.stuffName.charAt(i)) {
                    return 1;
                }

                if (stuffModel.stuffName.charAt(i) > this.stuffName.charAt(i)) {
                    return -1;
                }
            }
        }



        if (stuffModel.getAverageScore() > this.averageScore) {
            return 1;
        } else if (stuffModel.getAverageScore() < this.averageScore) {
            return -1;
        } else if (stuffModel.getStuffPrice() > this.stuffPrice) {
            return 1;
        } else if (stuffModel.getStuffPrice() < this.stuffPrice) {
            return -1;
        } else if (stuffModel.stuffInventory > this.stuffInventory) {
            return 1;
        } else {
            return stuffModel.stuffInventory < this.stuffInventory ? -1 : 0;
        }
    }

    public String toString() {
        String var10000 = this.stuffName;
        return "stuffName= " + var10000 + " stuffPrice= " + this.stuffPrice + " stuffId= " + this.stuffId + " stuffInventory= " + this.stuffInventory + " stuffKind= " + String.valueOf(this.stuffKindModel) + " average score: " + this.averageScore;
    }
}

