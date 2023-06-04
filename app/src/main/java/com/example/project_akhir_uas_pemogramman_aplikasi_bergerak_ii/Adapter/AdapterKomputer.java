package com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.Model.ModelKomputer;
import com.example.project_akhir_uas_pemogramman_aplikasi_bergerak_ii.R;

import java.util.List;

public class AdapterKomputer extends RecyclerView.Adapter<AdapterKomputer.VHKomputer> {
    private Context ctx;
    private List<ModelKomputer> listKomputer;

    public AdapterKomputer(Context ctx, List<ModelKomputer> listKomputer) {
        this.ctx = ctx;
        this.listKomputer = listKomputer;
    }

    @NonNull
    @Override
    public VHKomputer onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View varView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sparepart, parent, false);
        return new VHKomputer(varView);
    }

    @Override
    public void onBindViewHolder(@NonNull VHKomputer holder, int position) {
        ModelKomputer MK = listKomputer.get(position);
        holder.tvId.setText(MK.getId());
        holder.tvNama.setText(MK.getNama());
        holder.tvDeskripsi.setText(MK.getDeskripsi());
        holder.tvKategori.setText(MK.getKategori());
    }

    @Override
    public int getItemCount() {
        return listKomputer.size();
    }

    public class VHKomputer extends RecyclerView.ViewHolder {
        TextView tvId, tvNama, tvKategori, tvDeskripsi;


        public VHKomputer(@NonNull View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tv_id);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            tvKategori = itemView.findViewById(R.id.tv_kategori);

        }
    }

}
