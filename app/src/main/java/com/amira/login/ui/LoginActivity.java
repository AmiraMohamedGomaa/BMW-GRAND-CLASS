package com.amira.login.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.amira.login.data.ApiResponse;
import com.amira.login.model.response.LoginResponse;
import com.amira.navigationdrawer.R;
import com.amira.navigationdrawer.ui.main_drawer.MainActivity;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email, pass;
    Button login;
    LoginResponse loginResponse;
    ProgressBar progressBar;
    public SharedPreferences sharedPreferences;
    LoginViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_login_page );

        sharedPreferences=getSharedPreferences( "userPref", Context.MODE_PRIVATE );

      email = findViewById( R.id.tv_email );
       pass = findViewById( R.id.tv_pass );
        login=findViewById( R.id.btn_login );
        progressBar=findViewById( R.id.login_progress );

        userViewModel= ViewModelProviders.of(this).get( LoginViewModel.class );
        userViewModel.mutableLiveData.observe( this, loginResponse -> {
            Toast.makeText( LoginActivity.this,loginResponse.getUserData().getEmail(),Toast.LENGTH_LONG ).show();
            //setUserData( loginResponse );
        } );

                login.setOnClickListener( v -> {

              if (checkValidation( email, pass )){
                  Toast.makeText( LoginActivity.this,"success",Toast.LENGTH_LONG ).show();
                    userViewModel.getData( email.getText().toString(), pass.getText().toString(), sharedPreferences );
              }
              Intent i=new Intent(LoginActivity.this, MainActivity.class );
              startActivity( i );
                } );




    }


    public boolean checkValidation(EditText email, EditText pass) {
        if (email.getText().toString().equals( "" ) || pass.getText().toString().equals( "" )) {
            Toast.makeText( LoginActivity.this, "Empty text", Toast.LENGTH_LONG ).show();
            return false;
        }
         return true;
    }

    public void setUserData(LoginResponse response){
        Toast.makeText( LoginActivity.this,response.getUserData().getEmail(),Toast.LENGTH_LONG ).show();

    }



}