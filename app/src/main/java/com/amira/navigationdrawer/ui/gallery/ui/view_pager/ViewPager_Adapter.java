package com.amira.navigationdrawer.ui.gallery.ui.view_pager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.amira.navigationdrawer.ui.gallery.model.response.CarModel;

import java.util.ArrayList;

public class ViewPager_Adapter extends FragmentStatePagerAdapter {
    ArrayList<CarModel.GalleriesBean> galleriesList=new ArrayList<>();

    public ViewPager_Adapter(@NonNull FragmentManager fm) {
        super( fm );
    }

    public void setData(ArrayList<CarModel.GalleriesBean> list){
        this.galleriesList=list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        TabFragment fragment = TabFragment.newInstance( galleriesList.get( position).getGalleryImages() );
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return galleriesList.get( position ).getName();
    }

    @Override
    public int getCount() {
        return galleriesList.size();
    }
}
