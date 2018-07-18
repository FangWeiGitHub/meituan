package com.example.meituan.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meituan.R;
import com.example.meituan.homepage.presenter.ShopPresenterimpl;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

public class HomeShowActivity extends AppCompatActivity implements HomePagerview{

    private TextView show_title;
    private RecyclerView show_recycler;
    private PullToRefreshScrollView pull_listview;
    private ShopPresenterimpl shopPresenterimpl;
    private int page=0;
    private boolean load=true;
    private boolean push=false;
    private boolean pull=false;
    private shopAdapter shopadapter;
    private List<ShopBean.DataBean> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_show);
        pull_listview=findViewById(R.id.pull_listview);
        //初始化控件
        show_title = findViewById(R.id.show_title);
        String title = getIntent().getStringExtra("title");
        //设置标题
        show_title.setText(title);
        show_recycler = findViewById(R.id.show_recycle);
        show_recycler.setLayoutManager(new LinearLayoutManager(HomeShowActivity.this,LinearLayoutManager.VERTICAL,false));
        pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
        shopPresenterimpl = new ShopPresenterimpl(this);
        shopPresenterimpl.getdata(page);
        pull_listview.setMode(PullToRefreshBase.Mode.BOTH);
        pull_listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
               /* shopPresenterimpl.getdata(page);
                shop_pull.onRefreshComplete();*/
                change(false,true,false);
                if(page>1){
                    page--;
                    shopPresenterimpl.getdata(page);
                }else{
                    pull_listview.onRefreshComplete();
                }

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                change(false,false,true);
               page++;
                shopPresenterimpl.getdata(page);
                pull_listview.onRefreshComplete();

            }

        });


    }
    public  void change(boolean b1,boolean b2,boolean b3){
        load=b1;
        pull=b2;
        push=b3;
    }
    @Override
    public void onSuccess(ShopBean shopBean) {
        data = shopBean.getData();
        if(data!=null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (load) {
                        shopadapter = new shopAdapter(HomeShowActivity.this, data);
                        show_recycler.setAdapter(shopadapter);
                        //shopadapter.add(data);
                    } else if (pull) {
                        shopadapter.add(data);
                    } else {
                        shopadapter.load(data);
                    }
                    pull_listview.onRefreshComplete();

                }
            });
        }
    }

    @Override
    public void onError(int code) {

    }
}
