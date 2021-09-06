package com.amira.navigationdrawer.ui.ourpartner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.amira.navigationdrawer.R;

public class OurpartnerFragment extends Fragment {

    private OurpartnerViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider( this ).get( OurpartnerViewModel.class );
        View root = inflater.inflate( R.layout.fragment_ourpartners, container, false );
       // final TextView textView = root.findViewById( R.id.text_slideshow );
        slideshowViewModel.getText().observe( getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        } );
        return root;
    }
}