package com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String alamatServer = "http://uaspab2.000webhostapp.com/retrieve.com/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit() {
        if(retro == null)
        {
            retro = new Retrofit.Builder()
                    .baseUrl(alamatServer)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
