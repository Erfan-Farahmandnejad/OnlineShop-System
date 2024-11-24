package com.example.model.Roles;

import com.example.model.Stuff.StuffModel;
import com.example.model.UserModelFacilities.DiscountModel;
import com.example.model.UserModelFacilities.PurchaseInvoiceModel;

import java.util.ArrayList;

public class ClientModel extends UserModel {
    private double accountCredit;
    private ArrayList<StuffModel>cart;
    private ArrayList<PurchaseInvoiceModel>clientInvoicesList;
    private ArrayList<DiscountModel>clientDiscounts;
    public ClientModel(String userName,String email,String phoneNumber,String password)
    {
        super(userName, password, phoneNumber, email);
        cart=new ArrayList<>();
        clientInvoicesList=new ArrayList<>();
        clientDiscounts=new ArrayList<>();
        accountCredit=100000;
    }

    public ArrayList<PurchaseInvoiceModel> getClientInvoicesList() {
        return clientInvoicesList;
    }

    public ArrayList<StuffModel> getCart() {
        return cart;
    }

    public double getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(double accountCredit) {
        this.accountCredit = accountCredit;
    }

    public ArrayList<DiscountModel> getClientDiscounts() {
        return clientDiscounts;
    }

    @Override
    public String toString() {
        return super.toString()+
                " accountCredit=" + accountCredit
                ;
    }
}
