package com.example.HelpMeRelax_v1_0.ui.Help;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HelpViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HelpViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is help fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}