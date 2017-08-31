package com.example.jaruwatsukkhamjohn.liveat500px.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jaruwat Sukkhamjohn on 29/8/2560.
 */

public class PhotoitemCollectionDao implements Parcelable{

    @SerializedName("successs") private boolean success;
    @SerializedName("data")     private List<PhotoitemDao> data;

    public PhotoitemCollectionDao(){

    }

    protected PhotoitemCollectionDao(Parcel in) {
        success = in.readByte() != 0;
        data = in.createTypedArrayList(PhotoitemDao.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (success ? 1 : 0));
        dest.writeTypedList(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoitemCollectionDao> CREATOR = new Creator<PhotoitemCollectionDao>() {
        @Override
        public PhotoitemCollectionDao createFromParcel(Parcel in) {
            return new PhotoitemCollectionDao(in);
        }

        @Override
        public PhotoitemCollectionDao[] newArray(int size) {
            return new PhotoitemCollectionDao[size];
        }
    };

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
