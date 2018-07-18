package com.example.meituan.homepage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.meituan.R;

import java.util.List;

/**
 * Created by 小薇 on 2018/7/16.
 */

public class shopAdapter extends RecyclerView.Adapter<shopAdapter.TextHolder>{
    private Context context;
    private List<ShopBean.DataBean> dataBeans;

    public shopAdapter(Context context, List<ShopBean.DataBean> dataBeans) {
        this.context = context;
        this.dataBeans = dataBeans;
    }

    @NonNull
    @Override
    public TextHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextHolder(LayoutInflater.from(context).inflate(R.layout.shoplist,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextHolder holder, final int position) {
        Glide.with(context).load(dataBeans.get(position).getPic_url()).into(holder.title_ion);
        holder.name.setText(dataBeans.get(position).getName());
        holder.average_price.setText(dataBeans.get(position).getAverage_price_tip());
        holder.distance.setText(dataBeans.get(position).getDistance());
        holder.min_price.setText(dataBeans.get(position).getMin_price()+"|");
        holder.month_sales.setText(dataBeans.get(position).getMin_price());
        holder.time.setText(dataBeans.get(position).getDelivery_time_tip()+"/");
        holder.shipping_fee.setText(dataBeans.get(position).getShipping_fee_tip()+"|");

        if(listener!=null){
           holder.relativelayout.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   listener.onItemClick(position);
               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public void add(List<ShopBean.DataBean> data) {
        this.dataBeans.addAll(0,data);
        notifyDataSetChanged();
    }

    public void load(List<ShopBean.DataBean> data) {
        this.dataBeans.addAll(data);
        notifyDataSetChanged();
    }

    class TextHolder extends RecyclerView.ViewHolder{


        private  ImageView title_ion;
        private  TextView name;
        private  TextView month_sales;
        private  TextView time;
        private TextView distance;
        private  TextView min_price;
        private TextView shipping_fee;
        private  TextView average_price;
        private  RelativeLayout relativelayout;

        public TextHolder(View itemView) {
            super(itemView);
            title_ion = itemView.findViewById(R.id.title_ion);
            name = itemView.findViewById(R.id.name);
            month_sales = itemView.findViewById(R.id.month_sales);
            time = itemView.findViewById(R.id.titme);
            distance=itemView.findViewById(R.id.distance);
            min_price = itemView.findViewById(R.id.min_price);
            shipping_fee = itemView.findViewById(R.id.shipping_fee);
            average_price = itemView.findViewById(R.id.average_price);
            relativelayout = itemView.findViewById(R.id.relativelayout);
        }
    }

    public interface ItemClickListener{
        void onItemClick(int position);
    }
    public ItemClickListener listener;

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }
}
