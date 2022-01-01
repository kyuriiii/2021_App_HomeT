package com.example.mobile_filnalproject.ui.homecook;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeCookViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeCookViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home  cook fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}