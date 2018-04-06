package com.example.user.lifeplant.WsClass;

import android.content.Context;

import com.example.user.lifeplant.Models.PicModel;
import com.google.gson.Gson;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class WsProduct {
    private Context context;
//    private String message;
//    private boolean success;


    public WsProduct(final Context context) {
        this.context = context;
    }

//    public boolean
// isSuccess() {
//        return success;
//    }
//
//    public String getMessage() {
//        return message;
//    }

    /**
     * Method to execute service and parse response.
     */
    public PicModel executeService(final String pid) {
        final String url = WSConstants.BASE_URL + WSConstants.METHOD_PRODUCTDETAIL;
        final String response = new WSUtil().callServiceHttpPost(url, generateproduct(pid));
        return parseResponse(response);
    }

    /* Parse the json response in string.
     *
     * @param response
     */
    private PicModel parseResponse(final String response) {
        PicModel picModel = new PicModel();
        if (response != null && response.trim().length() > 0) {
            try {
                final Gson gson = new Gson();
                picModel = gson.fromJson(response, PicModel.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return picModel;
    }

    private RequestBody generateproduct(final String pid) {
        final WSConstants wsConstants = new WSConstants();
        final FormBody.Builder formEncodingBuilder = new FormBody.Builder();
        formEncodingBuilder.add(wsConstants.PARAMS_PROID, pid);

        return formEncodingBuilder.build();
    }

}
