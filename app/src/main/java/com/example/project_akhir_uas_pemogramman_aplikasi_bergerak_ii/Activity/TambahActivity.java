package com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.R;

public class TambahActivity extends AppCompatActivity {

    private EditText etNama, etKategori, etDeskripsi, etType, etKapasitas;
    private Button btnSimpan;
    private String nama, kategori, deskripsi, type, kapasitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
    }
}