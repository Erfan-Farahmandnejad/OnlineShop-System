package com.example.model.Roles;

public abstract class UserModel {
    private final String userName;
    private String email;
    private String phoneNumber;
    private String password;
    public UserModel(String userName,String password,String phoneNumber,String email)
    {
        this.userName=userName;
        this.password=password;
        this.phoneNumber=phoneNumber;
        this.email=email;
    }
    public UserModel(String userName,String password)
    {
     this(userName,password,null,null);
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\''
                ;
    }
}
