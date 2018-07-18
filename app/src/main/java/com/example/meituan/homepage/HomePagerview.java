package com.example.meituan.homepage;

/**
 * Created by 小薇 on 2018/7/16.
 */


public interface HomePagerview {

    void onSuccess(ShopBean shopBean);

    void onError(int code);
}
