package com.amira.login.data;

import com.amira.login.model.body.LoginReqBody;
import com.amira.login.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserInterface {
    @POST("Login.php")
    Call<LoginResponse> createNewUser(@Body LoginReqBody reqBody);

}
