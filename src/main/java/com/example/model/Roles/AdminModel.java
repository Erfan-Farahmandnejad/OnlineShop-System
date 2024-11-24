package com.example.model.Roles;

import com.example.model.Stuff.StuffModel;

import java.util.ArrayList;

public class AdminModel extends UserModel {
    private ArrayList<StuffModel>stuffList=new ArrayList<>();
    private static AdminModel adminModel=new AdminModel("admin","admin");
    private AdminModel(String userName,String password)
    {
        super(userName, password);
        stuffList=new ArrayList<>();
    }

    public static AdminModel getAdminModel() {
        return adminModel;
    }

    public ArrayList<StuffModel> getStuffList() {
        return stuffList;
    }
}
