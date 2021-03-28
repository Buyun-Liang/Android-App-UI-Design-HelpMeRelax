package com.example.HelpMeRelax_v1_0.ui.funding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FundingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FundingViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is funding fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}