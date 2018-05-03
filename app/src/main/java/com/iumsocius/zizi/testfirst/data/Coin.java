package com.iumsocius.zizi.testfirst.data;

public class Coin {
    private String result;
    private String volume;
    private String last;
    private String yesterday_last;
    private String timestamp;
    private String yesterday_low;
    private String high;
    private String currency;
    private String low;
    private String errprCode;
    private String yesterday_first;
    private String yesterday_volume;
    private String yesterday_high;
    private String first;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getLast() {
        return Long.parseLong(last);
    }

    public void setLast(long last) {
        this.last = String.valueOf(last);
    }
}
