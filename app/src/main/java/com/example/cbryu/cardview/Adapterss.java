package com.example.cbryu.cardview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapterss extends RecyclerView.Adapter<Adapterss.ViewHolder> {


    private ArrayList<Modelss> modelsss=new ArrayList<>();
    private Context context;

    public Adapterss(ArrayList<Modelss> modelsss) {
        this.modelsss = modelsss;

    }

    public Adapterss(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View ad= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem,viewGroup,false);
        return new ViewHolder(ad);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Modelss modelss=modelsss.get(i);
        viewHolder.ta.setText(modelss.getNmss());
        viewHolder.carda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,DetailActivity.class);
                intent.putExtra("id",modelss.getNmss());
                context.startActivity(intent);
            }
        });
    }



    public void setlist(ArrayList<Modelss> modelsss){
        this.modelsss=modelsss;
        notifyItemRangeChanged(0,modelsss.size());

    }

    public int getItemCount() {
        return modelsss.size();
    }
    public class  ViewHolder extends RecyclerView.ViewHolder {
        CardView carda;
        TextView ta;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            carda=itemView.findViewById(R.id.card);
            ta=itemView.findViewById(R.id.txt);
        }
    }
    public  void removea(int posi){
        modelsss.remove(posi);
        notifyItemRemoved(posi);
        notifyItemRangeChanged(0,modelsss.size());
    }
}
