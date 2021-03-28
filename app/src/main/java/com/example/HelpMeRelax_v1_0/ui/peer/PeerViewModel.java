package com.example.HelpMeRelax_v1_0.ui.peer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PeerViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PeerViewModel() {
        mText = new MutableLiveData<>();
//        mText.setValue("This is peer fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}