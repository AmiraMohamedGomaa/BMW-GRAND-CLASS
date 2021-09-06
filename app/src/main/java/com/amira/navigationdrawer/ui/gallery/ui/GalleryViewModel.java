package com.amira.navigationdrawer.ui.gallery.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.amira.login.data.ApiResponse;
import com.amira.navigationdrawer.ui.gallery.data.CarInterface;
import com.amira.navigationdrawer.ui.gallery.model.body.CarResq;
import com.amira.navigationdrawer.ui.gallery.model.response.CarModel;
import com.amira.navigationdrawer.ui.main_drawer.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryViewModel extends ViewModel {

     MutableLiveData<CarModel>carModelMutableLiveData=new MutableLiveData<>();
    CarInterface carInterface;
    ProgressBar progressBar;
    CarModel carModel;


    public  void getData(String id, String user_auth) {
        ///
        CarResq carResq = new CarResq(id,user_auth );
        carInterface = ApiResponse.getApiData().create( CarInterface.class );
        Call<CarModel> call = carInterface.createCarGallery( carResq );
        carModel=new CarModel();
        call.enqueue( new Callback<CarModel>() {
            @Override
            public void onResponse(Call<CarModel> call, Response<CarModel> response) {
                carModelMutableLiveData.setValue( response.body());
             //  Toast.makeText(context,carModelMutableLiveData.getValue().getMessageText(),Toast.LENGTH_LONG ).show();

            }

            @Override
            public void onFailure(Call<CarModel> call, Throwable t) {
                String error = t.toString();
                try {
                    throw new InterruptedException( "Something went wrong!" );
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        } );
    }

  public  void chechRequest(String id ,String user_auth){

        getData( id,user_auth );
  }





}