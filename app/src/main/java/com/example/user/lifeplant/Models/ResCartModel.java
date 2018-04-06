package com.example.user.lifeplant.Models;

import com.google.gson.annotations.SerializedName;

public class ResCartModel {
    @SerializedName("response")
    private Integer response;
    @SerializedName("result")
    private String result;
    @SerializedName("msg")
    private String msg;

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
