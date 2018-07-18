package com.example.meituan.MyModule.bean;

/**
 * Created by 小薇 on 2018/7/17.
 */

public class FirstBean {

    private int ion;
    private String name;

    public FirstBean(int ion, String name) {
        this.ion = ion;
        this.name = name;
    }

    public int getIon() {
        return ion;
    }

    public void setIon(int ion) {
        this.ion = ion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FirstBean{" +
                "ion=" + ion +
                ", name='" + name + '\'' +
                '}';
    }
}
