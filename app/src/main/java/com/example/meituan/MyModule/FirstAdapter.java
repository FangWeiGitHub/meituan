package com.example.meituan.MyModule;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meituan.MyModule.bean.FirstBean;
import com.example.meituan.R;
import com.example.meituan.homepage.NavAdapter;

import java.util.List;

/**
 * Created by 小薇 on 2018/7/17.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.ViewHolder>{
    private Context context;
    private List<FirstBean> firstBeans;

    public FirstAdapter(Context context, List<FirstBean> firstBeans) {
        this.context = context;
        this.firstBeans = firstBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.homepage_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.homepage_text.setText(firstBeans.get(position).getName());
        holder.homepage_ion.setImageResource(firstBeans.get(position).getIon());
    }

    @Override
    public int getItemCount() {
        return firstBeans.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView homepage_ion;
        private TextView homepage_text;
        public ViewHolder(View itemView) {
            super(itemView);
            homepage_ion=itemView.findViewById(R.id.homepage_ion);
            homepage_text=itemView.findViewById(R.id.homepage_text);
        }
    }
}
