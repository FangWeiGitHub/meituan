package com.example.meituan.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.meituan.MyModule.FirstAdapter;
import com.example.meituan.MyModule.ThreeAdapter;
import com.example.meituan.MyModule.TwoAdapter;
import com.example.meituan.MyModule.TwoBean;
import com.example.meituan.MyModule.bean.FirstBean;
import com.example.meituan.MyModule.bean.ThreeBean;
import com.example.meituan.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {


    private TextView login;
    private ImageView finish;
    private RecyclerView my_recycler;
    private List<FirstBean> firstBeans;
    private FirstAdapter firstAdapter;
    private RecyclerView twoRecycle;
    private List<TwoBean> twoBeans;
    private TwoAdapter twoAdapter;
    private RecyclerView threeRecycler;
    private ThreeAdapter threeAdapter;
    private List<ThreeBean> threeBeans;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        //初始化控价
        finish = view.findViewById(R.id.finsh);
        login = view.findViewById(R.id.login);
        my_recycler = view.findViewById(R.id.my_recycler);
        twoRecycle = view.findViewById(R.id.two_recycler);
        threeRecycler = view.findViewById(R.id.three_recycler);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         initfirst();
         inittwo();
         initthree();
    }

    private void initthree() {
        threeRecycler.setLayoutManager(new GridLayoutManager(getActivity(),4));
        threeBeans = new ArrayList<>();
        threeBeans.add(new ThreeBean(R.drawable.jiang,"邀请有奖"));
        threeBeans.add(new ThreeBean(R.drawable.shang,"商家入驻"));
        threeBeans.add(new ThreeBean(R.drawable.help,"帮助与反馈"));
        threeBeans.add(new ThreeBean(R.drawable.kefu,"在线客服"));
        threeAdapter = new ThreeAdapter(getActivity(),threeBeans);
        threeRecycler.setAdapter(threeAdapter);
    }


    private void inittwo() {
        twoRecycle.setLayoutManager(new GridLayoutManager(getActivity(),4));
        twoBeans = new ArrayList<>();
        twoBeans.add(new TwoBean(R.drawable.hong,"红包"));
        twoBeans.add(new TwoBean(R.drawable.dai,"代金卷"));
        twoBeans.add(new TwoBean(R.drawable.money,"钱包"));
        twoBeans.add(new TwoBean(R.drawable.yu,"余额"));
        twoAdapter = new TwoAdapter(getActivity(),twoBeans);
        twoRecycle.setAdapter(twoAdapter);

    }

    private void initfirst() {
        my_recycler.setLayoutManager(new GridLayoutManager(getActivity(),4));
        firstBeans = new ArrayList<>();
        firstBeans.add(new FirstBean(R.drawable.shoucang,"我的收藏"));
        firstBeans.add(new FirstBean(R.drawable.foot,"我的足迹"));
        firstBeans.add(new FirstBean(R.drawable.ping,"我的评价"));
        firstBeans.add(new FirstBean(R.drawable.frient,"我的好友"));
        firstBeans.add(new FirstBean(R.drawable.da,"答谢记录"));
        firstBeans.add(new FirstBean(R.drawable.add,"我的地址"));
        firstAdapter = new FirstAdapter(getActivity(),firstBeans);
        my_recycler.setAdapter(firstAdapter);
    }
}
