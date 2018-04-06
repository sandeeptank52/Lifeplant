package com.example.user.lifeplant.WsClass;

import android.content.Context;

import com.example.user.lifeplant.Models.ResSignupModel;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.RequestBody;


public class WSSignUp {
    private Context context;

    public WSSignUp(final Context context) {
        this.context = context;
    }

    private ResSignupModel parseResponse(final String response) {
        ResSignupModel resSignupModel = new ResSignupModel();
        if (response != null && response.trim().length() > 0) {
            try {
                final Gson gson = new Gson();
                resSignupModel = gson.fromJson(response, ResSignupModel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resSignupModel;
    }

    public ResSignupModel executeService(final String fname, final String lname, final String gender, final String mobileno, final String email, final String password, final String birthdate) {
        final String url = WSConstants.BASE_URL + WSConstants.METHOD_SIGNUP;
        final String response = new WSUtil().callServiceHttpPost(url, generateSignupRequest(fname, lname, gender, mobileno, email, password, birthdate));
        return parseResponse(response);
    }

    private RequestBody generateSignupRequest(final String fname, final String lname, final String gender, final String mobileno, final String email, final String password, final String birthdate) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_FNAME, fname);
        formEncodingBuilder.add(wsConstants.PARAMS_LNAME, lname);
        formEncodingBuilder.add(wsConstants.PARAMS_GENDER, gender);
        formEncodingBuilder.add(wsConstants.PARAMS_MOBNO, mobileno);
        formEncodingBuilder.add(wsConstants.PARAMS_EMAIL, email);
        formEncodingBuilder.add(wsConstants.PARAMS_PASSWORD, password);
        formEncodingBuilder.add(wsConstants.PARAMS_BIRTHD, birthdate);
        return formEncodingBuilder.build();
    }

}
