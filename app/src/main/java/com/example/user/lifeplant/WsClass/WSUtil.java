package com.example.user.lifeplant.WsClass;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Web Service utility class to call web urls. And returns response.
 */
public class WSUtil {
    public String callServiceHttpPost(final String url, final RequestBody requestBody) {
        Log.e(WSUtil.class.getSimpleName(), String.format("Request String : %s", requestBody.toString()));
        String responseString = "";
        try {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            final Response response = okHttpClient.newCall(request).execute();
            responseString = response.body().string();
            Log.e("TAG", "Response String : " + responseString);
            if (TextUtils.isEmpty(responseString) || !isJSONValid(responseString)) {
                responseString = getNetWorkError();
            }
        } catch (IOException e) {
            e.printStackTrace();
            responseString = getNetWorkError();
        }
        return responseString;

    }

    public String callServiceHttpGet(final String url) {
        String responseString = "";
        try {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(WSConstants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            final Response response = okHttpClient.newCall(request).execute();
            responseString = response.body().string();
            Log.e("TAG", "Response String : " + responseString);
            if (TextUtils.isEmpty(responseString) || !isJSONValid(responseString)) {
                responseString = getNetWorkError();
            }
        } catch (IOException e) {
            e.printStackTrace();
            responseString = getNetWorkError();
        }
        return responseString;
    }


    private String getNetWorkError() {
        final JSONObject jsonObject = new JSONObject();
        try {
            final WSConstants wsConstants = new WSConstants();
            jsonObject.put(wsConstants.PARAMS_RESPONSE, 1);
            jsonObject.put(wsConstants.PARAMS_SUCCESS, "Network error. Please try again after some time");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }


    private boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            // edited, to include @Arthur's comment
            // e.g. in case JSONArray is valid as well...
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

}
