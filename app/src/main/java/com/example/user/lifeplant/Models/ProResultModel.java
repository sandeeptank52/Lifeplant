package com.example.user.lifeplant.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
public class ProResultModel implements Parcelable {


    @SerializedName("cate_id")
    private String cateId;

    @SerializedName("cate_name")
    private String cateName;

    @SerializedName("pic")
    private String picpath;

    @SerializedName("products")
    private List<ResProductModel> products = null;

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public List<ResProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ResProductModel> products) {
        this.products = products;
    }


    protected ProResultModel(Parcel in) {
        cateId = in.readString();
        cateName = in.readString();
        picpath = in.readString();
        if (in.readByte() == 0x01) {
            products = new ArrayList<ResProductModel>();
            in.readList(products, ResProductModel.class.getClassLoader());
        } else {
            products = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cateId);
        dest.writeString(cateName);
        dest.writeString(picpath);
        if (products == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(products);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ProResultModel> CREATOR = new Parcelable.Creator<ProResultModel>() {
        @Override
        public ProResultModel createFromParcel(Parcel in) {
            return new ProResultModel(in);
        }

        @Override
        public ProResultModel[] newArray(int size) {
            return new ProResultModel[size];
        }
    };
}