package com.amira.navigationdrawer.ui.gallery.ui.view_pager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.amira.navigationdrawer.R;
import com.amira.navigationdrawer.ui.gallery.model.response.CarModel;
import com.amira.navigationdrawer.ui.gallery.ui.GalleryAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabFragment extends Fragment {
    RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "List";

    // TODO: Rename and change types of parameters
    private ArrayList<CarModel.GalleriesBean.GalleryImagesBean> mParam1=new ArrayList<>();

    public TabFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static TabFragment newInstance(ArrayList<CarModel.GalleriesBean.GalleryImagesBean> imagesList) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList( ARG_PARAM1, imagesList );
        fragment.setArguments( args );
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelableArrayList( ARG_PARAM1 );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

           View v= inflater.inflate( R.layout.fragment_tab, container, false );

           return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );

       // Toast.makeText( getContext(),mParam1.get( 0 ).getId(),Toast.LENGTH_LONG ).show();

        GalleryAdapter galleryAdapter=new GalleryAdapter( mParam1);
        recyclerView=view.findViewById( R.id.rv_gallery );
        recyclerView.setLayoutManager( new GridLayoutManager( getContext() , 3 ) );
        recyclerView.setAdapter( galleryAdapter );

    }
}