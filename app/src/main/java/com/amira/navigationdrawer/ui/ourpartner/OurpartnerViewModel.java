package com.amira.navigationdrawer.ui.ourpartner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OurpartnerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OurpartnerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue( "This is slideshow fragment" );
    }

    public LiveData<String> getText() {
        return mText;
    }
}