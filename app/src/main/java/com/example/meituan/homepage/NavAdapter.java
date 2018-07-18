package com.example.meituan.homepage;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meituan.R;

import java.util.List;

/**
 * Created by 小薇 on 2018/7/12.
 */

public class NavAdapter extends RecyclerView.Adapter<NavAdapter.ViewHolder>{
    private Context context;
    private List<NavBean> navBeanList;

    public NavAdapter(Context context, List<NavBean> navBeanList) {
        this.context = context;
        this.navBeanList = navBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //寻找布局
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.homepage_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NavAdapter.ViewHolder holder, final int position) {
      //绑定数据
        holder.homepage_text.setText(navBeanList.get(position).getTitle());
        holder.homepage_ion.setImageResource(navBeanList.get(position).getIon());
        if(callBack!=null){
            holder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(context,HomeShowActivity.class);
                    intent.putExtra("title",navBeanList.get(position).getTitle());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return navBeanList.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder{

         private ImageView homepage_ion;
         private TextView homepage_text;
         private LinearLayout linearLayout;
         public ViewHolder(View itemView) {
             super(itemView);
             homepage_ion=itemView.findViewById(R.id.homepage_ion);
             homepage_text=itemView.findViewById(R.id.homepage_text);
             linearLayout=itemView.findViewById(R.id.linerlayout);
         }
     }

    public interface ClickListener{
        void onItemClick(int position);
    }
   public ClickListener callBack;

    public void setCallBack(ClickListener callBack) {
        this.callBack = callBack;
    }
}
