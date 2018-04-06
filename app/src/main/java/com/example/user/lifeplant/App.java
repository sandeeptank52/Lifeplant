package com.example.user.lifeplant;

import android.app.Application;

import com.example.user.lifeplant.Models.ResSignupModel;

import java.util.ArrayList;

public class App extends Application {
    private static App instance;

    public int age = 26;
   private ResSignupModel resSignupModel;
    private String userid = resSignupModel.getUserId();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if(instance !=null){
            instance =null;
        }
    }
}
