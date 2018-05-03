package com.iumsocius.zizi.testfirst.network;

import java.net.CookieManager;
import java.net.CookiePolicy;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zizi on 18/04/2018.
 */

public class RetrofitCreator {

    static String COINONE_URL = "https://api.coinone.co.kr/";

    static TestFirstService service = getService();

    public synchronized static TestFirstService getService() {
        if (service == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

            OkHttpClient httpClient = new OkHttpClient();

            service = new Retrofit.Builder()
                    .baseUrl(COINONE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(TestFirstService.class);
        }
        return service;
    }
}
