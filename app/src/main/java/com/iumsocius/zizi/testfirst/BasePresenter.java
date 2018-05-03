package com.iumsocius.zizi.testfirst;

/**
 * Created by zizi on 16/04/2018.
 */

public interface BasePresenter<T> {
    void setView(T view);
    void start();
}
