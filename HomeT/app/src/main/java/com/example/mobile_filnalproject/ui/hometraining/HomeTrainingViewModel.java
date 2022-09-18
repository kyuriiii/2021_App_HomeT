package com.example.mobile_filnalproject.ui.hometraining;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeTrainingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeTrainingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}