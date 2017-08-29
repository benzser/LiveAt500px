package com.example.jaruwatsukkhamjohn.liveat500px.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jaruwat Sukkhamjohn on 29/8/2560.
 */

public class PhotoitemCollectionDao {

    @SerializedName("successs") private boolean success;
    @SerializedName("data")     private List<PhotoitemDao> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PhotoitemDao> getData() {
        return data;
    }

    public void setData(List<PhotoitemDao> data) {
        this.data = data;
    }
}
