package com.example.user.lifeplant.Models;

import com.google.gson.annotations.SerializedName;
/**
 * Created by user on 16-02-2018.
 */

public class ResultModel {
    @SerializedName("fname")
    private String fname;
    @SerializedName("lname")

    private String lname;
    @SerializedName("gender")

    private String gender;
    @SerializedName("mobileno")

    private String mobileno;
    @SerializedName("email")

    private String email;
    @SerializedName("password")

    private String password;
    @SerializedName("birthdate")

    private String birthdate;
    @SerializedName("id")

    private String id;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}


