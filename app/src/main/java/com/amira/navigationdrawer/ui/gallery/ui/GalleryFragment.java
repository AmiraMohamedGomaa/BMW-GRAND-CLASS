package com.amira.navigationdrawer.ui.gallery.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.amira.navigationdrawer.R;
import com.amira.navigationdrawer.ui.gallery.model.response.CarModel;
import com.amira.navigationdrawer.ui.gallery.ui.view_pager.TabFragment;
import com.amira.navigationdrawer.ui.gallery.ui.view_pager.ViewPager_Adapter;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class GalleryFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPager_Adapter viewPager_adapter;
    ImageView mainImage;
    GalleryViewModel galleryViewModel;
    RecyclerView rv;
    SharedPreferences sharedPreferences;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate( R.layout.fragment_gallery, container, false );
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

        tabLayout=view.findViewById( R.id.gallery_tablayout );
        viewPager=view.findViewById( R.id.gallery_viewpager );
        mainImage=view.findViewById( R.id.main_image_img );
       galleryViewModel =new GalleryViewModel();




        galleryViewModel =new ViewModelProvider( getActivity() ).get( GalleryViewModel.class );
        galleryViewModel.carModelMutableLiveData.observe( getViewLifecycleOwner(), carModel -> {
            String MainImage =carModel.getGalleryMainImage();
           String url=GalleryAdapter.url+MainImage;
            Picasso.get().load( url ).into( mainImage );
            viewPager_adapter=new ViewPager_Adapter( getFragmentManager() );
            viewPager_adapter.setData( carModel.getGalleries() );
            viewPager.setAdapter( viewPager_adapter );
            tabLayout.setupWithViewPager( viewPager );
        } );

        getSharedPref_Galelry();




       //sharedPreferences =getSharedPreferences( "carpef",Context.MODE_PRIVATE);


         //galleryViewModel.carModelMutableLiveData.observe( this, );
       // rv=view.findViewById( R.id.rv );
      //  GalleryAdapter galleryAdapter=new GalleryAdapter(  galleryViewModel.setCarImages());
       // rv.setLayoutManager( new GridLayoutManager( getContext(),2 ) );
        //rv.setAdapter( galleryAdapter );

        //viewPager_adapter=new ViewPager_Adapter( getFragmentManager() );
        //Tab tab=new Tab(  )
    }

    public void getSharedPref_Galelry(){
        sharedPreferences= getContext().getSharedPreferences( "userPref", Context.MODE_PRIVATE );
        if(sharedPreferences!=null){
            String id=sharedPreferences.getString( "carreq",null );
            String user_auth= sharedPreferences.getString( "tooken",null );
            galleryViewModel.chechRequest( id,user_auth );
        }
    }
}