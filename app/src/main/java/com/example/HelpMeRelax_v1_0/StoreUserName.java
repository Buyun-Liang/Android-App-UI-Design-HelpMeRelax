package com.example.HelpMeRelax_v1_0;

import android.app.Application;

public class StoreUserName extends Application {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
