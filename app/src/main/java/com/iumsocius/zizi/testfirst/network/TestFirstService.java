package com.iumsocius.zizi.testfirst.network;

import com.iumsocius.zizi.testfirst.data.Coin;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zizi on 18/04/2018.
 */

public interface TestFirstService {
    @GET("/ticker")
    Observable<Coin> getTicker(@Query("currency") String currency);
}
