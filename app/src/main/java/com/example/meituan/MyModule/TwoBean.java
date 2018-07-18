package com.example.meituan.MyModule;

/**
 * Created by 小薇 on 2018/7/17.
 */

public class TwoBean {
    private int ion;
    private String name;

    public TwoBean(int ion, String name) {
        this.ion = ion;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIon() {
        return ion;
    }

    public void setIon(int ion) {
        this.ion = ion;
    }

    @Override
    public String toString() {
        return "TwoBean{" +
                "ion=" + ion +
                ", name='" + name + '\'' +
                '}';
    }
}
