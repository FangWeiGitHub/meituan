package com.example.meituan.homepage.presenter;

import com.example.meituan.fragment.HomePageFragment;
import com.example.meituan.homepage.HomePagerview;
import com.example.meituan.homepage.ShopBean;
import com.example.meituan.homepage.model.ShopModel;
import com.example.meituan.homepage.model.ShopModelImpl;

/**
 * Created by 小薇 on 2018/7/16.
 */

public class ShopPresenterimpl implements  ShopPresenter{

   private HomePagerview homePagerview;
    private ShopModelImpl shopModel;

    public ShopPresenterimpl(HomePagerview homePagerview) {
        this.homePagerview=homePagerview;
        this.shopModel = new ShopModelImpl();
    }
    //数据
    public void getdata(int page){
        //调用model中的方法
        shopModel.getdata(new ShopModel() {
            @Override
            public void onSuccessData(ShopBean shopBean,int page) {
                   homePagerview.onSuccess(shopBean);
            }

            @Override
            public void onError(int code) {
                homePagerview.onError(code);
            }
        },page);
    }
    @Override
    public void onDestroy() {
     if(homePagerview!=null){
         homePagerview=null;
     }
    }
}
