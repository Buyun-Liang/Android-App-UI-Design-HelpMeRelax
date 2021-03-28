package com.example.HelpMeRelax_v1_0.ui.health;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HealthViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HealthViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is health fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}