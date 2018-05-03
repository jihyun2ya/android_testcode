package com.iumsocius.zizi.testfirst.data;

/**
 * Created by zizi on 18/04/2018.
 */

public class Wallet {

    private User user;
    private Coin coin;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void addAmount(int addedAmount) {
        this.amount = amount + addedAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}
