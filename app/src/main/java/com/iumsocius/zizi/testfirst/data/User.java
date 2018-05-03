package com.iumsocius.zizi.testfirst.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by zizi on 18/04/2018.
 */

public class User {

    private String name;
    private ArrayList<Wallet> wallets;

    public ArrayList<Wallet> getWallets() {
        return wallets;
    }

    public long getBalance() {
        long balance = 0;
        for (Wallet wallet : wallets) {
            Coin coin = wallet.getCoin();
            balance = balance + coin.getLast() * wallet.getAmount();
        }
        return balance;
    }

    public void addWallets(Wallet w){
        if (wallets == null)
            wallets = new ArrayList<Wallet>();
        wallets.add(w);
    }

    public void removeWallets(String coin){
        for (Wallet wallet : wallets) {
            if (wallet.getCoin().getCurrency().equals(coin)) {
                wallets.remove(wallet);
            }
        }
    }
}
