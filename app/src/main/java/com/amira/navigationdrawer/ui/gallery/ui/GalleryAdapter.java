package com.amira.navigationdrawer.ui.gallery.ui;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amira.navigationdrawer.R;
import com.amira.navigationdrawer.ui.gallery.model.response.CarModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
   ArrayList<CarModel.GalleriesBean.GalleryImagesBean>carModels;
   static final String url="http://166.62.117.167/BMW_GKL/uploads/";
    public GalleryAdapter(ArrayList<CarModel.GalleriesBean.GalleryImagesBean> carModels) {
        this.carModels = carModels;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from( parent.getContext() ).inflate( R.layout.gallery_cardview,
                null,false );
        GalleryViewHolder galleryViewHolder=new GalleryViewHolder( v );
        return galleryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        CarModel.GalleriesBean.GalleryImagesBean carModel=carModels.get( position );
       // holder.img.setImageResource( carModel.CREATOR.createFromParcel( carModels ).getImage() );
        Picasso.get().load( url+carModel.getImage() ).into( holder.img );
    }

    @Override
    public int getItemCount() {
        return carModels.size();
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public GalleryViewHolder(@NonNull View itemView) {
            super( itemView );
            img=itemView.findViewById( R.id.car_card );
        }
    }
}
