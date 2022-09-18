package com.example.mobile_filnalproject.ui.onlinegame;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OnlineGameViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OnlineGameViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is online game fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}