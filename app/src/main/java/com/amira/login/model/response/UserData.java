package com.amira.login.model.response;

public class UserData {
    private String id;
    private String chassis_number;
    private String password;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private String user_auth;
    private String allow_notifi;
    private String last_login;
    private String signedUp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChassis_number() {
        return chassis_number;
    }

    public void setChassis_number(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_auth() {
        return user_auth;
    }

    public void setUser_auth(String user_auth) {
        this.user_auth = user_auth;
    }

    public String getAllow_notifi() {
        return allow_notifi;
    }

    public void setAllow_notifi(String allow_notifi) {
        this.allow_notifi = allow_notifi;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getSignedUp() {
        return signedUp;
    }

    public void setSignedUp(String signedUp) {
        this.signedUp = signedUp;
    }
}
