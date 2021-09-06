package com.amira.login.ui;

import android.content.SharedPreferences;
import android.widget.ProgressBar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.amira.login.data.ApiResponse;
import com.amira.login.data.UserInterface;
import com.amira.login.model.body.LoginReqBody;
import com.amira.login.model.response.LoginResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    MutableLiveData<LoginResponse>mutableLiveData=new MutableLiveData<>();
    UserInterface userinterface;
    LoginResponse loginResponse;
    ProgressBar progressBar;

    public void getData(String mail, String pass,SharedPreferences sharedPreferences) {
        ///
        LoginReqBody reqBody = new LoginReqBody( mail, pass );
        userinterface = ApiResponse.getApiData().create( UserInterface.class );
        Call<LoginResponse> call = userinterface.createNewUser( reqBody );
        loginResponse=new LoginResponse();
        call.enqueue( new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               checkPref( response,sharedPreferences );
                mutableLiveData.setValue( response.body() );

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                String error = t.toString();
                try {
                    throw new InterruptedException( "Something went wrong!" );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } );
    }

    public void checkPref(Response<LoginResponse> response,SharedPreferences sharedPreferences){
        loginResponse=response.body();
        SharedPreferences.Editor sharedVariable=sharedPreferences.edit();
        sharedVariable.putString( "carreq", loginResponse.getUserData().getId());
        sharedVariable.putString( "tooken",loginResponse.getUserData().getUser_auth() );
        sharedVariable.commit();
    }



}
