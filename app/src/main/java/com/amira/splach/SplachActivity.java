package com.amira.splach;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.amira.login.ui.LoginActivity;
import com.amira.navigationdrawer.R;
import com.amira.navigationdrawer.ui.main_drawer.MainActivity;

import java.util.logging.Handler;

public class SplachActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String userTook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_splach );


        sharedPreferences = getSharedPreferences( "userPref", Context.MODE_PRIVATE );
        if (sharedPreferences != null) {
            userTook = sharedPreferences.getString( "tooken", null );
        }
        //Toast.makeText( this,LoginActivity.sharedPreferences.getString( "tooken","Empty" ),Toast.LENGTH_LONG ).show();

        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep( 5000 );
                    if (userTook == null) {
                        Intent i = new Intent( SplachActivity.this, LoginActivity.class );
                        startActivity( i );
                        finish();

                    } else {
                        Intent i = new Intent( SplachActivity.this, MainActivity.class );
                        startActivity( i );
                    }
                } catch (Exception e) {

                }
            }
        };
        splash.start();
    }

}