package com.example.meituan.homepage.model;

import android.util.Log;

import com.example.meituan.homepage.ShopBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 小薇 on 2018/7/16.
 */

public class ShopModelImpl {
    //获取数据
    public void getdata(final ShopModel shopModel, final int page){
        //okhttp
        OkHttpClient okHttpClient=new OkHttpClient
                .Builder()
                .build();
        //request
        Request request=new Request
                .Builder()
                .url("http://39.108.3.12:3000/v1/restaurants?offset="+page+"&limit=4&lng=116.29845&lat=39.95933")
                .build();
        //执行
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                shopModel.onError(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.i("aaa",str.toString());
                Gson gson=new Gson();
                ShopBean shopBean = gson.fromJson(str, ShopBean.class);
                shopModel.onSuccessData(shopBean,page);
                Log.i("aaa",shopBean.getData().get(0).getName());
            }
        });
    }
}
