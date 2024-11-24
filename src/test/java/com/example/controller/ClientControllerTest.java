package com.example.controller;

import com.example.Exceptions.*;
import com.example.model.Roles.AdminModel;
import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.CarModel;
import com.example.model.UserModelFacilities.CommentModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ClientControllerTest {


//    @Rule
//    public ExpectedException exceptionRule = ExpectedException.none();
    private ClientController sut=new ClientController();
    private ClientModel sut1=new ClientModel("erf","erf@gmail.com","09162225555","Ss112233");

    @Test
   public void testSignUpAllSituations()  {

        assertThrows(InvalidPassword.class,
                () ->  sut.signUp("erf", "erf@gmail.com", "09161135833", "pa"));

        assertThrows(InvalidEmail.class,
                () -> sut.signUp("erf", "email", "09161135833", "Pa112233"));

        assertThrows(InvalidPhoneNumber.class,
                () -> sut.signUp("erf", "erf@gmail.com", "phoneNumber", "Pa112233"));



    }

    @Test
    public void testSignInAllSituations() {

        AdminController.getClientList().add(sut1);

        assertEquals("erf", sut.signIn("erf", "Ss112233", 1));
        assertEquals("admin", sut.signIn("admin", "admin",0));
        assertEquals("failed to login", sut.signIn("erf", "Ss112233", 0));
        assertEquals("failed to login", sut.signIn("erfan", "Ss112233", 1));

        AdminController.getClientList().remove(sut1);

    }

    @Test
    public void testEditPasswordAllSituations() throws Exception {

        AdminController.getClientList().add(sut1);

        assertEquals(0, sut.editPassword("erf", "Ss112233"));
        assertEquals(0, sut.editPassword("yazdan", "Ss112233"));
        assertEquals(0, sut.editPassword("yazdan", "Ss112239"));
        assertEquals(1, sut.editPassword("erf", "Ss112239"));
        assertThrows(InvalidPassword.class, () -> sut.editPassword("erf", "password"));

        AdminController.getClientList().remove(sut1);

    }

    @Test
    public void testEditEmailAllSituations() throws Exception {

        AdminController.getClientList().add(sut1);

        assertEquals(0, sut.editEmail("erf", "erf@gmail.com"));
        assertEquals(0, sut.editEmail("yazdan", "erf@gmail.com"));
        assertEquals(0, sut.editEmail("yazdan", "er@gmail.com"));
        assertEquals(1, sut.editEmail("erf", "er@gmail.com"));
        assertThrows(InvalidEmail.class, () -> sut.editEmail("yazdan", "email"));
        assertThrows(InvalidEmail.class, () -> sut.editEmail("erf", "email"));

        AdminController.getClientList().remove(sut1);

    }

    @Test
    public void testEditPhoneNumberAllSituations() throws Exception {

        AdminController.getClientList().add(sut1);

        assertEquals(0, sut.editPhoneNumber("erf", "09162225555"));
        assertEquals(0, sut.editPhoneNumber("yazdan", "09162225555"));
        assertEquals(0, sut.editPhoneNumber("yazdan", "09162225554"));
        assertEquals(1, sut.editPhoneNumber("erf", "09162225554"));
        assertThrows(InvalidPhoneNumber.class, () -> sut.editPhoneNumber("yazdan", "phoneNumber"));
        assertThrows(InvalidPhoneNumber.class, () -> sut.editPhoneNumber("erf", "phoneNumber"));

        AdminController.getClientList().remove(sut1);
    }

    @Test
    public void testRateToStuffAllSituations() throws Exception {

        //Arrange
        AdminController.getClientList().add(sut1);
        CarModel carModel=new CarModel("m3",300,3,"bmw",3000,true);
        carModel.setStuffId(0);
        AdminModel.getAdminModel().getStuffList().add(carModel);
        sut1.getCart().add(carModel);
        sut.ultimatePurchase(sut1.getUserName(),0);

        assertEquals(1, sut.rateToStuff(5, "erf", 0));
        assertEquals(0, sut.rateToStuff(5, "erf", 20));
        assertEquals(0, sut.rateToStuff(5, "yazdan", 20));
        assertEquals(0, sut.rateToStuff(5, "yazdan", 0));

        AdminController.getClientList().remove(sut1);

    }

    @Test
    public void testAccountChargeRequest() {

        AdminController.getClientList().add(sut1);


        assertEquals("An error acquired", sut.accountChargeRequest("erf", "cardNumber", "123", "1234567", 10000.2));
        assertEquals("An error acquired", sut.accountChargeRequest("erf", "1111222233334444", "11111111", "1234567", 10000.2));
        assertEquals("An error acquired", sut.accountChargeRequest("erf", "1111222233334444", "123", "ssss", 10000.2));
        assertEquals("An error acquired", sut.accountChargeRequest("erfan", "1111222233334444", "123", "1234567", 10000.2));
        assertEquals("accountChargeRequest: " + "erf" + " " + "10000.2", sut.accountChargeRequest("erf", "1111222233334444", "123", "1234567", 10000.2));

        AdminController.getClientList().remove(sut1);
    }

    @Test
    public void testAddStuffToCart() throws Exception {

        AdminController.getClientList().add(sut1);
        CarModel carModel=new CarModel("m3",300,3,"bmw",3000,true);
        carModel.setStuffId(0);
        AdminModel.getAdminModel().getStuffList().add(carModel);
        CarModel carModel1=new CarModel("m4",300,0,"bmw",3000,true);
        carModel1.setStuffId(1);
        AdminModel.getAdminModel().getStuffList().add(carModel1);

        assertEquals(1, sut.addStuffToCart("erf", 0, 1));
        assertEquals(0, sut.addStuffToCart("erf", 20, 1));
        assertEquals(0, sut.addStuffToCart("erf", 1, 1));

        AdminController.getClientList().remove(sut1);

    }

    @Test
    public void testRemoveStuffFromCart() {

        AdminController.getClientList().add(sut1);
        CarModel carModel=new CarModel("m3",300,3,"bmw",3000,true);
        carModel.setStuffId(0);
        AdminModel.getAdminModel().getStuffList().add(carModel);
        sut1.getCart().add(carModel);

        assertEquals(1, sut.removeStuffFromCart("erf", 0));
        assertEquals(0, sut.removeStuffFromCart("yazdan", 0));
        assertEquals(0, sut.removeStuffFromCart("erf", 20));
    }

    @Test
    public void testWriteComment() throws Exception {

        AdminController.getClientList().add(sut1);
        CarModel carModel=new CarModel("m3",300,3,"bmw",3000,true);
        carModel.setStuffId(0);
        AdminModel.getAdminModel().getStuffList().add(carModel);

        CarModel carModel1=new CarModel("m4",300,3,"bmw",3000,true);
        carModel1.setStuffId(1);
        AdminModel.getAdminModel().getStuffList().add(carModel1);

        sut1.getCart().clear();
        sut1.getCart().add(carModel);
        sut.ultimatePurchase("erf",0);

        CommentModel commentModel=new CommentModel(0,"commentText",sut1);
        commentModel.setBuy(true);

        CommentModel commentModel1=new CommentModel(1,"commentText1",sut1);
        commentModel1.setBuy(true);


        assertEquals("comment request failed", sut.writeComment("erf", 20, commentModel.getCommentText()));
        assertEquals("commentRequest: " + commentModel1.toString(), sut.writeComment("erf", 1, commentModel1.getCommentText()));
        assertEquals("commentRequest: " + commentModel.toString(), sut.writeComment("erf", 0, commentModel.getCommentText()));
        assertEquals("comment request failed", sut.writeComment("yazdan", 0, commentModel.getCommentText()));

        AdminModel.getAdminModel().getStuffList().remove(carModel1);
        AdminModel.getAdminModel().getStuffList().remove(carModel);
        AdminController.getClientList().remove(sut1);
    }

    @Test
    public void testUltimatePurchase() throws Exception {

        AdminController.getClientList().add(sut1);
        CarModel carModel=new CarModel("m3",300,3,"bmw",3000,true);
        carModel.setStuffId(0);
        AdminModel.getAdminModel().getStuffList().add(carModel);
        sut1.getCart().add(carModel);
        carModel.setStuffPrice(100000000);
        assertThrows(InsufficientBalance.class, () -> sut.ultimatePurchase("erf", 0));
        carModel.setStuffPrice(1000);
        assertEquals("purchase was successful", sut.ultimatePurchase("erf", 0));
        assertEquals("purchase wasn't successful", sut.ultimatePurchase("yazdan", 0));
        carModel.setStuffInventory(0);
        assertThrows(InsufficientInventory.class, () -> sut.ultimatePurchase("erf", 0));
        carModel.setStuffInventory(3);

        sut1.getCart().remove(carModel);
        AdminController.getClientList().remove(sut1);

    }
}
