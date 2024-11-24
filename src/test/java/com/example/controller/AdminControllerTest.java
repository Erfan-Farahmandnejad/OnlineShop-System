package com.example.controller;

import com.example.model.Roles.AdminModel;
import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.CarModel;
import com.example.model.Stuff.PencilKindModel;
import com.example.model.Stuff.PencilModel;
import com.example.model.UserModelFacilities.CommentModel;
import com.example.model.UserModelFacilities.DiscountModel;
import com.example.model.UserModelFacilities.ScoreModel;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AdminControllerTest {

    private AdminController sut=new AdminController();


    @Test
    public void testGetClientList() {

        final ArrayList<ClientModel> result = AdminController.getClientList();

    }

    @Test
    public void testGetAllRequestList() {

        final ArrayList<String> result = AdminController.getAllRequestList();
    }

    @Test
    public void testGetAllScores() {

        final ArrayList<ScoreModel> result = AdminController.getAllScores();

    }

    @Test
    public void testAddStuff() {

        assertEquals(0, sut.addStuff("stuff Information"));
        assertEquals(1, sut.addStuff("s CarModel X5 200.3 2 bmw 3300 true"));

    }

    @Test
    public void testEditStuffName() {
        CarModel carModel=new CarModel("X5",2000.5,3,"Bmw",4000,true);
        carModel.setStuffId(2);
        AdminModel.getAdminModel().getStuffList().add(carModel);


        assertEquals(0, sut.editStuffName(0, "name"));
        assertEquals(1, sut.editStuffName(2, "name"));
    }

    @Test
    public void testEditStuffInventory() {

        CarModel carModel=new CarModel("X5",2000.5,3,"Bmw",4000,true);
        carModel.setStuffId(2);
        AdminModel.getAdminModel().getStuffList().add(carModel);

        assertEquals(1, sut.editStuffInventory(2, 2));
        assertEquals(0, sut.editStuffInventory(3, 2));
    }

    @Test
    public void testEditStuffPrice() {

        CarModel carModel=new CarModel("X5",2000.5,3,"Bmw",4000,true);
        carModel.setStuffId(2);
        AdminModel.getAdminModel().getStuffList().add(carModel);

        assertEquals(1, sut.editStuffPrice(2, 0.0));
        assertEquals(0, sut.editStuffPrice(20, 0.0));
    }

    @Test
    public void testRemoveStuff() {

        CarModel carModel=new CarModel("X5",2000.5,3,"Bmw",4000,true);
        carModel.setStuffId(2);
        AdminModel.getAdminModel().getStuffList().add(carModel);

        assertEquals(1, sut.removeStuff(2));
        assertEquals(0, sut.removeStuff(20));

    }

    @Test
    public void testAcceptOrRejectRequests() {

        CarModel carModel=new CarModel("X5",2000.5,3,"Bmw",4000,true);
        carModel.setStuffId(2);
        AdminModel.getAdminModel().getStuffList().add(carModel);

        ClientModel clientModel=new ClientModel("erf","e@gmail.com","09161135831","Ss112233");
        AdminController.getClientList().add(clientModel);

        CommentModel commentModel=new CommentModel(2,"salamInTeste",clientModel);
        AdminController.getAllRequestList().add("commentRequest: " + commentModel.toString());

        assertEquals("0_String(comment accepted)", sut.acceptOrRejectRequests(0, 1));
    }

    @Test
    public void testGiveClientsDiscount() {

        ClientModel clientModel=new ClientModel("erf","e@gmail.com","09161135831","Ss112233");
        AdminController.getClientList().add(clientModel);

        DiscountModel discountModel=new DiscountModel(33,"2025/11/11",3);
        clientModel.getClientDiscounts().add(discountModel);

        assertEquals("give Discount to erf successfully done", sut.giveClientsDiscount("erf", "33 2025/11/11 3"));
    }

    @Test
    public void testSomeStuffDiscounts() {

        PencilModel pencilModel=new PencilModel("zebra",200.5,4,"Germany", PencilKindModel.H2);
        AdminModel.getAdminModel().getStuffList().add(pencilModel);
        pencilModel.setStuffId(5);

        assertEquals("Pencil "+pencilModel.getStuffName()+" got discount", sut.someStuffDiscounts(5, 20));
    }

    @Test
    public void testRemoveSomeStuffDiscount() {

        PencilModel pencilModel=new PencilModel("zebra",200.5,4,"Germany", PencilKindModel.H2);
        AdminModel.getAdminModel().getStuffList().add(pencilModel);
        pencilModel.setStuffId(5);

        sut.someStuffDiscounts(5,23);

        assertEquals("Pencil "+pencilModel.getStuffName()+ " discount has been removed", sut.removeSomeStuffDiscount(5));
    }

    @Test
    public void testRemoveClientDiscount() {

        ClientModel clientModel=new ClientModel("erf","e@gmail.com","09161135831","Ss112233");
        AdminController.getClientList().add(clientModel);

        DiscountModel discountModel=new DiscountModel(33,"2025/11/11",3);
        clientModel.getClientDiscounts().add(discountModel);

        assertEquals("Discount removed successfully", sut.removeClientDiscount("erf", discountModel.getDiscountCode()));
    }
}