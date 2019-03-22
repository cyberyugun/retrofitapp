package com.example.cbryu.cardview;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private List<Wisata> wisatas;
    private Context context;


    public Adapter(List<Wisata> wisatas, Context context) {
        this.wisatas = wisatas;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int i) {
        myViewHolder.idwisata.setText(wisatas.get(i).getIdwisata());
        myViewHolder.namawisata.setText(wisatas.get(i).getNamawisata());
        myViewHolder.tempatwisata.setText(wisatas.get(i).getTempatwisata());
        myViewHolder.deskripsi.setText(wisatas.get(i).getDeskripsi());
        myViewHolder.harga.setText(wisatas.get(i).getHarga());
       myViewHolder.hps.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent().setClass(context,WisataHapusActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.putExtra("idwisata",wisatas.get(i).getIdwisata());
               context.startActivity(intent);
           }
       });

       myViewHolder.ws=wisatas.get(i);

    }

    @Override
    public int getItemCount() {
        return wisatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView idwisata,namawisata,tempatwisata,deskripsi,harga;
Button hps;
Wisata ws;
        public MyViewHolder(View itemView){
            super(itemView);
            idwisata=itemView.findViewById(R.id.idwisata);
            namawisata=itemView.findViewById(R.id.namawisata);
            tempatwisata=itemView.findViewById(R.id.tempatwisata);
            deskripsi=itemView.findViewById(R.id.deskripsi);
            harga=itemView.findViewById(R.id.harga);
       hps=itemView.findViewById(R.id.hapus);
itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent ambil=new Intent(context,UpdateDataActivity.class);
        ambil.putExtra("idwisata",ws.getIdwisata());
        ambil.putExtra("namawisata",ws.getNamawisata());
        ambil.putExtra("tempatwisata",ws.getTempatwisata());
        ambil.putExtra("deskripsi",ws.getDeskripsi());
        ambil.putExtra("harga",ws.getHarga());
    context.startActivity(ambil);
    }
});
        }

    }
}
