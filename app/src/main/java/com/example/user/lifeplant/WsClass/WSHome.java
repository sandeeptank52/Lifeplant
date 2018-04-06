package com.example.user.lifeplant.WsClass;

import android.content.Context;

import com.example.user.lifeplant.Models.ResHomeModel;
import com.example.user.lifeplant.Models.ResSignupModel;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.RequestBody;


public class WSHome {
    private Context context;

    public WSHome(final Context context) {
        this.context = context;
    }

    private ResHomeModel parseResponse(final String response) {
        ResHomeModel resSignupModel = new ResHomeModel();
        if (response != null && response.trim().length() > 0) {
            try {
                final Gson gson = new Gson();
                resSignupModel = gson.fromJson(response, ResHomeModel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resSignupModel;
    }

    public ResHomeModel executeService() {
        final String url = WSConstants.BASE_URL + WSConstants.METHOD_HOME;
        final String response = new WSUtil().callServiceHttpGet(url);
        return parseResponse(response);
    }


}
