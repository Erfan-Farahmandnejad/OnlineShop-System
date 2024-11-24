package com.example.controller;

import com.example.Exceptions.*;
import com.example.javafxproject.UltimatePurchaseController;
import com.example.model.Roles.AdminModel;
import com.example.model.Roles.ClientModel;
import com.example.model.Stuff.StuffModel;
import com.example.model.UserModelFacilities.CommentModel;
import com.example.model.UserModelFacilities.DiscountModel;
import com.example.model.UserModelFacilities.PurchaseInvoiceModel;
import com.example.model.UserModelFacilities.ScoreModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientController {
    public String signUp(String userName, String email, String phoneNumber, String password) throws InvalidEmail, InvalidPhoneNumber, InvalidPassword {

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@(gmail|yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        Pattern pattern1 = Pattern.compile("^09\\d{9}$");
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        Pattern pattern2 = Pattern.compile("(\\S){8,}");
        Pattern pattern20 = Pattern.compile("[a-z]+");
        Pattern pattern21 = Pattern.compile("[A-Z]+");
        Pattern pattern22 = Pattern.compile("[0-9]+");
        Matcher matcher2 = pattern2.matcher(password);
        Matcher matcher20 = pattern20.matcher(password);
        Matcher matcher21 = pattern21.matcher(password);
        Matcher matcher22 = pattern22.matcher(password);


        if (matcher.find() == true && matcher1.find() == true && matcher2.find() == true && matcher20.find() == true && matcher21.find() == true && matcher22.find() == true) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (userName.equals(clientModel.getUserName())) {
                    return "This userName has been taken";
                }
            }
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (phoneNumber.equals(clientModel.getPhoneNumber())) {
                    return "This phoneNumber has been taken";
                }
            }
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (email.equals(clientModel.getEmail())) {
                    return "This email has been taken";
                }
            }
            AdminController.getAllRequestList().add("SignUpRequest: " + userName +
                    " " + email + " " + phoneNumber + " " + password);
            return "SignUpRequest: " + userName +
                    " " + email + " " + phoneNumber + " " + password;
        }
        if (!matcher2.find() || !matcher20.find() || !matcher21.find() || !matcher22.find())
        {
            throw new InvalidPassword();
        }
        if (!matcher1.find()) {
            throw new InvalidPhoneNumber();
        }
        if (!matcher.find()) {
            throw new InvalidEmail();

        }

        return "Invalid Password";
    }

    public String signIn(String userName, String password, int role) {
        if (role == 1) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (userName.equals(clientModel.getUserName()) && password.equals(clientModel.getPassword())) {
                    return userName;
                }
            }
            return "failed to login";
        } else {
            if (userName.equals("admin") && password.equals("admin")) {
                return "admin";
            }
        }
        return "failed to login";
    }

    public int editPassword(String userName, String password) throws InvalidPassword {
        Pattern pattern2 = Pattern.compile("(\\S){8,}");
        Pattern pattern20 = Pattern.compile("[a-z]+");
        Pattern pattern21 = Pattern.compile("[A-Z]+");
        Pattern pattern22 = Pattern.compile("[0-9]+");
        Matcher matcher2 = pattern2.matcher(password);
        Matcher matcher20 = pattern20.matcher(password);
        Matcher matcher21 = pattern21.matcher(password);
        Matcher matcher22 = pattern22.matcher(password);


        if (matcher2.find() && matcher20.find() && matcher21.find() && matcher22.find()) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (clientModel.getUserName().equals(userName)) {
                    if (clientModel.getPassword() != password) {
                        clientModel.setPassword(password);
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
            return 0;
        }
        if (!matcher2.find() && !matcher20.find() && !matcher21.find() && !matcher22.find())
        {
            throw new InvalidPassword();
        }
        return 0;
    }

    public int editEmail(String userName, String email) throws InvalidEmail {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@(gmail|yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (clientModel.getUserName().equals(userName)) {
                    if (clientModel.getEmail() != email) {
                        clientModel.setEmail(email);
                        return 1;
                    }
                }
            }
        }
        else
            if (!matcher.find())
            {
                throw new InvalidEmail();
            }
        return 0;
    }

    public int editPhoneNumber(String userName, String phoneNumber) throws InvalidPhoneNumber {
        Pattern pattern1 = Pattern.compile("^09\\d{9}$");
        Matcher matcher1 = pattern1.matcher(phoneNumber);
        if (matcher1.find()) {
            for (ClientModel clientModel : AdminController.getClientList()) {
                if (clientModel.getUserName().equals(userName)) {
                    if (clientModel.getPhoneNumber() != phoneNumber) {
                        clientModel.setPhoneNumber(phoneNumber);
                        return 1;
                    }
                }
            }
        } else throw new InvalidPhoneNumber();
        return 0;
    }

    public int rateToStuff(int score, String userName, int stuffCode) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                int scoreSum = 0, scoreNumbers = 0;
                for (PurchaseInvoiceModel purchaseInvoiceModel : clientModel.getClientInvoicesList()) {
                    for (StuffModel stuffModel : purchaseInvoiceModel.getPurchasedStuffsList()) {
                        if (stuffModel.getStuffId() == stuffCode) {
                            if (score>5)
                            {
                                score=5;
                            }
                            if (score<0)
                            {
                                score=0;
                            }
                            ScoreModel scoreModel = new ScoreModel(clientModel, score, stuffModel);
                            AdminController.getAllScores().add(scoreModel);
                            for (ScoreModel scoreModel1 : AdminController.getAllScores()) {
                                if (scoreModel1.getStuffModel().getStuffId() == stuffCode) {
                                    scoreSum += scoreModel1.getScoreNumber();
                                    scoreNumbers++;
                                }
                            }
                            stuffModel.setAverageScore(scoreSum / scoreNumbers);
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public String accountChargeRequest(String userName, String cardNumber, String cvv2, String password, double chargeAmount) {
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(cardNumber);
        Pattern pattern1 = Pattern.compile("^\\d{3,4}$");
        Matcher matcher1 = pattern1.matcher(cvv2);
        Pattern pattern2 = Pattern.compile("^\\d{7}$");
        Matcher matcher2 = pattern2.matcher(password);

        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                if (matcher.find() && matcher1.find() && matcher2.find()) {
                    AdminController.getAllRequestList().add("accountChargeRequest: " + userName + " " + chargeAmount);
                    return "accountChargeRequest: " + userName + " " + chargeAmount;
                }
            }
        }
        return "An error acquired";
    }

    public int addStuffToCart(String userName, int stuffCode, int number) {
        int num = 0;
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                    if (stuffModel.getStuffId() == stuffCode) {
                        for (int i = 0; i < number; i++) {
                            if (stuffModel.getStuffInventory() > num) {
                                clientModel.getCart().add(stuffModel);
                                num++;
                            }
                        }
                        if (num == 0) {
                            return 0;
                        }
                        if (num != 0) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int removeStuffFromCart(String userName, int stuffCode) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                for (StuffModel stuffModel : clientModel.getCart()) {
                    if (stuffModel.getStuffId() == stuffCode) {
                        clientModel.getCart().remove(stuffModel);
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public String writeComment(String userName, int stuffCode, String commentText) {
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                for (PurchaseInvoiceModel purchaseInvoiceModel : clientModel.getClientInvoicesList()) {
                    for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                        if (stuffModel.getStuffId() == stuffCode) {
                            CommentModel commentModel = new CommentModel(stuffCode, commentText, clientModel);
                            commentModel.setBuy(true);
                            AdminController.getAllRequestList().add("commentRequest: " + commentModel.toString());
                            return "commentRequest: " + commentModel.toString();
                        }
                    }
                }
                for (StuffModel stuffModel : AdminModel.getAdminModel().getStuffList()) {
                    if (stuffModel.getStuffId() == stuffCode) {
                        CommentModel commentModel = new CommentModel(stuffCode, commentText, clientModel);
                        commentModel.setBuy(false);
                        AdminController.getAllRequestList().add("commentRequest: " + commentModel.toString());
                        return "commentRequest: " + commentModel.toString();
                    }
                }
            }
        }
        return "comment request failed";
    }

    public String ultimatePurchase(String userName, int order) throws InsufficientBalance, InsufficientInventory, InvalidDiscount, InterruptedException {
        double sumOfStuffPrices = 0;
        for (ClientModel clientModel : AdminController.getClientList()) {
            if (clientModel.getUserName().equals(userName)) {
                for (StuffModel stuffModel : clientModel.getCart()) {
                    if (stuffModel.getStuffInventory() > 0) {
                        sumOfStuffPrices += stuffModel.getStuffPrice();
                    } else {

                        throw new InsufficientInventory();

                    }
                }

                    if (order == 1) {
                        UltimatePurchaseController ultimatePurchaseController=new UltimatePurchaseController();
                            ArrayList<DiscountModel> temp= ultimatePurchaseController.enterClientDiscounts();
                            for (DiscountModel discountModel:temp)
                            {
                                if (discountModel.getDiscountExpiration().isBefore(LocalDate.now()) || discountModel.getDiscountCapacity() == 0) {
                                    throw new InvalidDiscount();
                                } else {

                                    double sumOfStuffPrices1 = sumOfStuffPrices - (sumOfStuffPrices * (discountModel.getDiscountPercent() / 100));
                                    discountModel.setDiscountCapacity(discountModel.getDiscountCapacity() - 1);
                                    ultimatePurchaseController.effectOfDiscount(sumOfStuffPrices, sumOfStuffPrices1);
                                    sumOfStuffPrices = sumOfStuffPrices1;
                                }
                            }
                    }

                if (clientModel.getAccountCredit() >= sumOfStuffPrices) {
                    PurchaseInvoiceModel purchaseInvoiceModel = new PurchaseInvoiceModel("1402/01/15", sumOfStuffPrices);
                    for (StuffModel stuffModel : clientModel.getCart()) {
                        purchaseInvoiceModel.getPurchasedStuffsList().add(stuffModel);
                        stuffModel.setStuffInventory(stuffModel.getStuffInventory() - 1);

                    }
                    clientModel.setAccountCredit(clientModel.getAccountCredit() - sumOfStuffPrices);
                    clientModel.getClientInvoicesList().add(purchaseInvoiceModel);


                    return "purchase was successful";
                } else {

                    throw new InsufficientBalance();

                }
            }
        }
        return "purchase wasn't successful";
    }

}
