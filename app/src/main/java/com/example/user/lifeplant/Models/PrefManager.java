package com.example.user.lifeplant.Models;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Tejas Soni on 06-04-2018.
 */

public class PrefManager {

    Context context;

    public PrefManager(Context context) {
        this.context = context;
    }

    public void saveLoginDetails(String email) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Email", email);
        editor.commit();
    }

    public String getEmail() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Email", "");
    }

    public boolean isUserLogedOut() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("LoginDetails", Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("Email", "").isEmpty();
        return isEmailEmpty;//|| isPasswordEmpty;
    }

    public void savePid(String Pid) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Pid", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Pid", Pid);
        editor.commit();
    }
    public String getPid() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Pid", Context.MODE_PRIVATE);
        return sharedPreferences.getString("Pid", "");
    }

}

