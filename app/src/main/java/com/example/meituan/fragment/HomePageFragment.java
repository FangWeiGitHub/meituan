package com.example.meituan.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meituan.R;
import com.example.meituan.homepage.HomePagerview;
import com.example.meituan.homepage.Search;
import com.example.meituan.homepage.NavAdapter;
import com.example.meituan.homepage.NavBean;
import com.example.meituan.homepage.ShopBean;
import com.example.meituan.homepage.presenter.ShopPresenterimpl;
import com.example.meituan.homepage.shopAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements HomePagerview{


    private TextView iv_content;
    private RecyclerView myrecycler;
    private NavAdapter navAdapter;
    private List<NavBean> navBeanList;
    private RecyclerView shoplist;
    private ShopPresenterimpl shopPresenterimpl;
    private List<ShopBean.DataBean> data=new ArrayList<>();
    private shopAdapter shopadapter;
    private int page=0;
    private PullToRefreshScrollView shop_pull;
    private boolean load=true;
    private boolean push=false;
    private boolean pull=false;

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        //初始化控件
        //搜索商品
        iv_content = view.findViewById(R.id.iv_content);
        //商店的列表展示
        shoplist = view.findViewById(R.id.shoplist);
        //布局
        myrecycler = view.findViewById(R.id.myrecycler);
        shop_pull = view.findViewById(R.id.shop_pull);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //搜索商品事件
         iv_content.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(getActivity(),Search.class);
                 startActivity(intent);
             }
         });
         //填充布局
        initData();
        shoplist.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        shopPresenterimpl = new ShopPresenterimpl(this);
        shopPresenterimpl.getdata(page);
        shop_pull.setMode(PullToRefreshBase.Mode.BOTH);
        shop_pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
               /* shopPresenterimpl.getdata(page);
                shop_pull.onRefreshComplete();*/
               change(false,true,false);
               if(page>1){
                   page--;
                   shopPresenterimpl.getdata(page);
               }else{
                   shop_pull.onRefreshComplete();
               }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                change(false,false,true);
                page++;
                shopPresenterimpl.getdata(page);
                shop_pull.onRefreshComplete();
            }

        });


    }
public  void change(boolean b1,boolean b2,boolean b3){
        load=b1;
        pull=b2;
        push=b3;
}
    private void initData() {
        //填充数据
        navBeanList = new ArrayList<>();
        navBeanList.add(new NavBean(R.drawable.food,"美食"));
        navBeanList.add(new NavBean(R.drawable.shop,"美团超市"));
        navBeanList.add(new NavBean(R.drawable.fruit,"生鲜果蔬"));
        navBeanList.add(new NavBean(R.drawable.tea,"下午茶"));
        navBeanList.add(new NavBean(R.drawable.chooes,"正餐优选"));
        navBeanList.add(new NavBean(R.drawable.hum,"汉堡披萨"));
        navBeanList.add(new NavBean(R.drawable.run,"跑腿代购"));
        navBeanList.add(new NavBean(R.drawable.fast,"快餐简餐"));
        //设置布局
        myrecycler.setLayoutManager(new GridLayoutManager(getActivity(),4));
        //设置adapter
        navAdapter = new NavAdapter(getActivity(),navBeanList);
        myrecycler.setAdapter(navAdapter);
        navAdapter.setCallBack(new NavAdapter.ClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(),"条目位置"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    //成功调用的方法
    @Override
    public void onSuccess(ShopBean shopBean) {
        data = shopBean.getData();
        if(data!=null){
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(load){
                        shopadapter = new shopAdapter(getActivity(),data);
                        shoplist.setAdapter(shopadapter);
                        //shopadapter.add(data);
                    }else if(pull){
                        shopadapter.add(data);
                    }else{
                        shopadapter.load(data);
                    }
                    shop_pull.onRefreshComplete();

                }
            });
        }

    }
    //失败调用的方法
    @Override
    public void onError(int code) {

    }


}
