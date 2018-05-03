package com.iumsocius.zizi.testfirst.data;

import com.iumsocius.zizi.testfirst.BaseApplication;
import com.iumsocius.zizi.testfirst.R;
import com.iumsocius.zizi.testfirst.network.RetrofitCreator;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainData {

    ArrayList<Coin> coinArrayList;
    ArrayList<String> coinCurrencyArrayList;

    public MainData() {
        coinArrayList = new ArrayList<Coin>();
        coinCurrencyArrayList = new ArrayList<String>();
    }

    public ArrayList<Coin> getCoinArrayList() {
        coinCurrencyArrayList.add("iota");
        coinCurrencyArrayList.add("qtum");
        coinCurrencyArrayList.add("xrp");

        for (String currency : coinCurrencyArrayList) {
            fetchData(currency);
        }
        return coinArrayList;
    }

    public String getDescString() {
        String descString = "조회 가능한 코인 : ";

        for (String currency : coinCurrencyArrayList) {
            descString = descString + currency + " ";
        }

        return descString;
    }

    public String getLastPrice(String currency) {
        for (Coin coin : coinArrayList) {
            if (coin.getCurrency().equals(currency)) {
                return String.valueOf(coin.getLast());
            }
        }
        return BaseApplication.getApplication().getResources().getString(R.string.currency_error);
    }

    public boolean isValidCurrency(String currency) {
        for (Coin coin : coinArrayList) {
            if (coin.getCurrency().equals(currency)) {
                return true;
            }
        }
        return false;
    }

    public void fetchData(String currency) {
        RetrofitCreator.getService().getTicker(currency)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        coin -> {
                      coinArrayList.add(coin);
                  }
                );
    }
}
