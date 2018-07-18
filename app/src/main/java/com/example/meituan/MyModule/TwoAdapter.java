package com.example.meituan.MyModule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meituan.R;

import java.util.List;

/**
 * Created by 小薇 on 2018/7/17.
 */

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.ViewHolder>{
    private Context context;
    private List<TwoBean> twoBeans;

    public TwoAdapter(Context context, List<TwoBean> twoBeans) {
        this.context = context;
        this.twoBeans = twoBeans;
    }

    @NonNull
    @Override
    public TwoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.showlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TwoAdapter.ViewHolder holder, int position) {
        holder.homepage_text.setText(twoBeans.get(position).getName());
        holder.homepage_ion.setImageResource(twoBeans.get(position).getIon());
    }

    @Override
    public int getItemCount() {
        return twoBeans.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
         private ImageView homepage_ion;
         private TextView homepage_text;
         public ViewHolder(View itemView) {
             super(itemView);
             homepage_ion=itemView.findViewById(R.id.homepage_ion);
             homepage_text=itemView.findViewById(R.id.homepage_text);
         }
     }
}
