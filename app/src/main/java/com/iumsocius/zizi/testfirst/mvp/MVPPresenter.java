package com.iumsocius.zizi.testfirst.mvp;

import com.iumsocius.zizi.testfirst.BaseApplication;
import com.iumsocius.zizi.testfirst.R;
import com.iumsocius.zizi.testfirst.data.MainData;

/**
 * Created by zizi on 16/04/2018.
 */

public class MVPPresenter implements MVPContract.Presenter {

    private MainData data;
    private MVPContract.View view;

    @Override
    public void setView(MVPContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        data = new MainData();
        data.getCoinArrayList();
        view.setDesc(data.getDescString());
    }

    @Override
    public void onCheckClicked() {
        view.setText(String.valueOf(data.getLastPrice(view.getCurrency())));
    }

    @Override
    public void onTextChanged(CharSequence s) {
        if (s.length() == 0) {
            view.disableButtons();
        } else {
            view.enableButtons();
        }
    }

    @Override
    public void onChartClicked() {
        if (data.isValidCurrency(view.getCurrency())) {
            view.showChart(view.getCurrency());
        } else {
            view.setText(BaseApplication.getApplication().getResources().getString(R.string.currency_error));
        }
    }

}
