package com.example.user.lifeplant.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResHomeModel {


    @SerializedName("response")
    private Integer response;
    @SerializedName("result")

    private List<ProResultModel> result = null;

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public List<ProResultModel> getResult() {
        return result;
    }

    public void setResult(List<ProResultModel> result) {
        this.result = result;
    }


}
