package com.example.user.lifeplant.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PicModel {

    @SerializedName("response")
    private Integer response;
    @SerializedName("result")

    private List<Result> result = null;

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }


    public class Result {

        @SerializedName("id")
        private String id;

        @SerializedName("pro_id")
        private String proId;

        @SerializedName("pro_name")
        private String proName;

        @SerializedName("pro_detail")
        private String proDetail;

        @SerializedName("supp_id")
        private String suppId;

        @SerializedName("cate_id")
        private String cateId;

        @SerializedName("quntity")
        private String quntity;

        @SerializedName("pic_path")
        private String picPath;

        @SerializedName("price")
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProId() {
            return proId;
        }

        public void setProId(String proId) {
            this.proId = proId;
        }

        public String getProName() {
            return proName;
        }

        public void setProName(String proName) {
            this.proName = proName;
        }

        public String getProDetail() {
            return proDetail;
        }

        public void setProDetail(String proDetail) {
            this.proDetail = proDetail;
        }

        public String getSuppId() {
            return suppId;
        }

        public void setSuppId(String suppId) {
            this.suppId = suppId;
        }

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getQuntity() {
            return quntity;
        }

        public void setQuntity(String quntity) {
            this.quntity = quntity;
        }

        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

    }
}