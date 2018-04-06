package com.example.user.lifeplant.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ResProductModel implements Parcelable {
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




    protected ResProductModel(Parcel in) {
        id = in.readString();
        proId = in.readString();
        proName = in.readString();
        proDetail = in.readString();
        suppId = in.readString();
        cateId = in.readString();
        quntity = in.readString();
        picPath = in.readString();
        price = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(proId);
        dest.writeString(proName);
        dest.writeString(proDetail);
        dest.writeString(suppId);
        dest.writeString(cateId);
        dest.writeString(quntity);
        dest.writeString(picPath);
        dest.writeString(price);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ResProductModel> CREATOR = new Parcelable.Creator<ResProductModel>() {
        @Override
        public ResProductModel createFromParcel(Parcel in) {
            return new ResProductModel(in);
        }

        @Override
        public ResProductModel[] newArray(int size) {
            return new ResProductModel[size];
        }
    };
}