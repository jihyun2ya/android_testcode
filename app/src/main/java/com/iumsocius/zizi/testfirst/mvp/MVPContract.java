package com.iumsocius.zizi.testfirst.mvp;

import com.iumsocius.zizi.testfirst.BasePresenter;
import com.iumsocius.zizi.testfirst.BaseView;

/**
 * Created by zizi on 16/04/2018.
 */

public interface MVPContract {

    interface View extends BaseView<Presenter> {
        void setDesc(String text);
        void setText(String text);
        String getCurrency();
        void disableButtons();
        void enableButtons();
        void showChart(String currency);
    }

    interface Presenter extends BasePresenter<View> {
        void onCheckClicked();
        void onTextChanged(CharSequence s);
        void onChartClicked();
    }
}
