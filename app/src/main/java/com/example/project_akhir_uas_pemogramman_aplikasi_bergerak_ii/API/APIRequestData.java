package com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.API;

import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Model.ModelResponses;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequestData {

    @GET("retrieve.php")
    Call<ModelResponses> ardRetrieve();

    @FormUrlEncoded
    @POST("create.php")
    Call<ModelResponses> ardCreate(
            @Field("nama") String nama,
            @Field("asal") String asal,
            @Field("deskripsi_singkat") String deskripsi_singkat
    );

    @FormUrlEncoded
    @POST("update.php")
    Call<ModelResponses> ardUpdate(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("asal") String asal,
            @Field("deskripsi_singkat") String deskripsi_singkat
    );

    @FormUrlEncoded
    @POST("delete.php")
    Call<ModelResponses> ardDelete(
            @Field("id") String id
    );

}
