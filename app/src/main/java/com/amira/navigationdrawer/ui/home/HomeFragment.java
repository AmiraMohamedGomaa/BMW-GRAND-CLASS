package com.amira.navigationdrawer.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.amira.navigationdrawer.R;

public class HomeFragment extends Fragment {
    LinearLayout privilegeProgram,ourPartner,gallery,news,contactUs,showroos;
    Button facebook,youtube,twitter,instgram;
    private HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        homeViewModel = new ViewModelProvider( this ).get( HomeViewModel.class );
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate( R.layout.fragment_home, container, false );
       // final TextView textView = root.findViewById( R.id.text_home );
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );


        homeViewModel.getText().observe( getViewLifecycleOwner(),
                s -> Toast.makeText( getContext(),  s, Toast.LENGTH_LONG).show() );
        privilegeProgram=view.findViewById( R.id.pp_view);
        privilegeProgram.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController( getView() ).navigate(R.id.action_nav_home_to_privililegeProgram_Fragment);
            }
        } );

        ourPartner=view.findViewById( R.id.op_view );
        ourPartner.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController( getView() ).navigate(R.id.action_nav_home_to_nav_slideshow);
            }
        } );

        gallery=view.findViewById( R.id.galley_view );
        gallery.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController( getView() ).navigate(R.id.action_nav_home_to_nav_gallery);
            }
        } );

        news=view.findViewById( R.id.news_view );
        news.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController( getView() ).navigate(R.id.action_nav_home_to_news_Fragment);
            }
        } );

        contactUs=view.findViewById( R.id.contactus_view );
        contactUs.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController( getView() ).navigate(R.id.action_nav_home_to_contactUs_Fragment);
            }
        } );

        showroos=view.findViewById( R.id.showrooms_view );
        showroos.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController( getView() ).navigate(R.id.action_nav_home_to_showRooms_Fragment);
            }
        } );

        facebook=view.findViewById( R.id.fb_btn );
        facebook.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="https://www.facebook.com/BMW/";
                openWebsite( uri );

            }
        } );

        youtube=view.findViewById( R.id.youtube_btn);
        youtube.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="https://www.youtube.com/channel/UCYwrS5QvBY_JbSdbINLey6Q";
                openWebsite( uri );
            }
        } );

        twitter=view.findViewById( R.id.twitter_btn );
        twitter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="https://twitter.com/bmw?lang=ar";
                openWebsite( uri );
            }
        } );

        instgram=view.findViewById( R.id.instagram_btn );
        instgram.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="https://www.instagram.com/bmw/";
                openWebsite( uri );
            }
        } );
    }

    public void openWebsite(String uri){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData( Uri.parse(uri ) );
        startActivity( intent );
    }
}