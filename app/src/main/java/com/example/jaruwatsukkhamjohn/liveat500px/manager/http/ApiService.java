package com.example.jaruwatsukkhamjohn.liveat500px.manager.http;

import com.example.jaruwatsukkhamjohn.liveat500px.dao.PhotoitemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by Jaruwat Sukkhamjohn on 29/8/2560.
 */

public interface ApiService {

    @POST("list")
    Call<PhotoitemCollectionDao> loadPhotoList();

}