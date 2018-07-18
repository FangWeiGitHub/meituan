package com.example.meituan;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.meituan.R;
import com.example.meituan.fragment.HomePageFragment;
import com.example.meituan.fragment.MyFragment;
import com.example.meituan.fragment.OrderFragment;

public class MainActivity extends FragmentActivity{

    private RadioGroup radioGroup;
    private FragmentManager manager;
    private HomePageFragment homePageFragment;
    private MyFragment myFragment;
    private OrderFragment orderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        radioGroup = findViewById(R.id.radiogroup);
        //创建对象
        homePageFragment = new HomePageFragment();
        //获取事务管理
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.frame_layout,homePageFragment).commit();
        //监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction transaction = manager.beginTransaction();
                if(homePageFragment!=null){
                    transaction.hide(homePageFragment);
                }
                if(orderFragment!=null){
                    transaction.hide(orderFragment);
                }
                if(myFragment!=null){
                    transaction.hide(myFragment);
                }
                switch (i){
                    case R.id.homepage:
                        if(homePageFragment==null){
                            homePageFragment = new HomePageFragment();
                            transaction.add(R.id.frame_layout,homePageFragment);
                        }else{
                            transaction.show(homePageFragment);
                        }
                        break;
                    case R.id.order:
                        if(orderFragment==null){
                            orderFragment = new OrderFragment();
                            transaction.add(R.id.frame_layout,orderFragment);
                        }else{
                            transaction.show(orderFragment);
                        }
                        break;
                    case R.id.my:
                        if(myFragment==null){
                            myFragment = new MyFragment();
                            transaction.add(R.id.frame_layout,myFragment);
                        }else{
                            transaction.show(myFragment);
                        }
                        break;

                }
                transaction.commit();
            }
        });
    }
}
