package com.example.meituan.homepage.model;

import com.example.meituan.homepage.ShopBean;

/**
 * Created by 小薇 on 2018/7/16.
 */

public interface ShopModel {
    //成功的方法
    void onSuccessData(ShopBean shopBean,int page);
    //失败的方法
    void onError(int code);
}
