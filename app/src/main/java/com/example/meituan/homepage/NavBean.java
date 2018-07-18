package com.example.meituan.homepage;

/**
 * Created by 小薇 on 2018/7/12.
 */

public class NavBean {
    private int _id;
    private int ion;
    private String title;

    public NavBean(int _id, int ion, String title) {
        this._id = _id;
        this.ion = ion;
        this.title = title;
    }

    public NavBean(int ion, String title) {
        this.ion = ion;
        this.title = title;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getIon() {
        return ion;
    }

    public void setIon(int ion) {
        this.ion = ion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "NavBean{" +
                "_id=" + _id +
                ", ion=" + ion +
                ", title='" + title + '\'' +
                '}';
    }
}
