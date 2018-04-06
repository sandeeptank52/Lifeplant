package com.example.user.lifeplant.Models;

import com.google.gson.annotations.SerializedName;
/**
 * Created by user on 16-02-2018.
 */

public class ResLoginModel {
    @SerializedName("response")
    private Integer response;
    @SerializedName("result")
    private ResultModel result;
    @SerializedName("msg")
    private String msg;
    @SerializedName("message")
    private String message;


    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public ResultModel getResult() {
        return result;
    }

    public void setResult(ResultModel result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
