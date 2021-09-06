package com.amira.navigationdrawer.ui.gallery.model.body;

import com.google.gson.annotations.SerializedName;

public class CarResq {
    @SerializedName( "user_id" )
    private String id;
    @SerializedName( "user_auth" )
    private String user_auth;

    public CarResq(String id, String user_auth) {
        this.id = id;
        this.user_auth = user_auth;
    }

    public String getId() {
        return id;
    }

    public String getUser_auth() {
        return user_auth;
    }
}
