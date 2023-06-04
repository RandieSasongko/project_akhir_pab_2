package com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.API.APIRequestData;
import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.API.RetroServer;
import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Adapter.AdapterKomputer;
import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Model.ModelKomputer;
import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Model.ModelResponses;
import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvKomputer;
    private FloatingActionButton fabTambah;
    private RecyclerView.Adapter adKomputer;
    private ProgressBar pbKomputer;
    private RecyclerView.LayoutManager lmKomputer;
    private List<ModelKomputer> listKomputer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKomputer = findViewById(R.id.rv_komputer);
        fabTambah = findViewById(R.id.fab_tambah);
        pbKomputer = findViewById(R.id.pb_komputer);

        lmKomputer = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvKomputer.setLayoutManager(lmKomputer);

        fabTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TambahActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        retrieveKomputer();
    }

    public void retrieveKomputer(){
        pbKomputer.setVisibility(View.VISIBLE);

        APIRequestData ARD = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponses> proses = ARD.ardRetrieve();

        proses.enqueue(new Callback<ModelResponses>() {
            @Override
            public void onResponse(Call<ModelResponses> call, Response<ModelResponses> response) {
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();
                listKomputer = response.body().getData();

                adKomputer = new AdapterKomputer(MainActivity.this, listKomputer);
                rvKomputer.setAdapter(adKomputer);
                adKomputer.notifyDataSetChanged();
                pbKomputer.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ModelResponses> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
                pbKomputer.setVisibility(View.GONE);
            }
        });
    }
}