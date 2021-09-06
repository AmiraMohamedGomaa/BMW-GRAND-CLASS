package com.amira.login.model.response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName( "MessageText" )
    private String MessageText;
    private String status;
    @SerializedName( "user" )
    private UserData userData;


    public String getMessageText() {
        return MessageText;
    }

    public void setMessageText(String messageText) {
        MessageText = messageText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }


}
