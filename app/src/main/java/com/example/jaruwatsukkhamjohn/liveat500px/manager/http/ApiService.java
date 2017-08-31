package com.example.jaruwatsukkhamjohn.liveat500px.manager.http;

import com.example.jaruwatsukkhamjohn.liveat500px.dao.PhotoitemCollectionDao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Jaruwat Sukkhamjohn on 29/8/2560.
 */

public interface ApiService {

    @POST("list")
    Call<PhotoitemCollectionDao> loadPhotoList();

    @POST("list/after/{id}")
    Call<PhotoitemCollectionDao> loadPhotoListAfterId(@Path("id") int id);

    @POST("list/before/{id}")
    Call<PhotoitemCollectionDao> loadPhotoListBeforeId(@Path("id") int id);
}