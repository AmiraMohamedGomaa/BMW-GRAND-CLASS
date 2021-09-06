package com.amira.navigationdrawer.ui.gallery.data;



import com.amira.navigationdrawer.ui.gallery.model.body.CarResq;
import com.amira.navigationdrawer.ui.gallery.model.response.CarModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

 public interface CarInterface {
    @GET("getGalleryList.php")
    Call<CarModel> createCarGallery(@Body CarResq carResq);

}
