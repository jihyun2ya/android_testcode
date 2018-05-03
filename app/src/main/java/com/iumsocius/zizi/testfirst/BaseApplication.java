package com.iumsocius.zizi.testfirst;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by zizi on 18/04/2018.
 */

public class BaseApplication extends Application {

    private static volatile BaseApplication instance = null;

    public static BaseApplication getApplication() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
