package com.iumsocius.zizi.testfirst.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iumsocius.zizi.testfirst.R;
import com.iumsocius.zizi.testfirst.web.WebViewActivity;

/**
 * Created by zizi on 12/04/2018.
 */

public class MVPFragment extends Fragment implements MVPContract.View {

    private MVPContract.Presenter presenter;

    private View root;
    private EditText etCurrency;
    private Button btnCheck;
    private Button btnChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, container, false);
        etCurrency = root.findViewById(R.id.et_currency);
        btnCheck = root.findViewById(R.id.btn_check);
        btnChart = root.findViewById(R.id.btn_chart);

        btnCheck.setOnClickListener(v -> {
            presenter.onCheckClicked();
        });

        etCurrency.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.onTextChanged(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        btnChart.setOnClickListener(v -> {
            presenter.onChartClicked();
        });

        return root;
    }

    @Override
    public void showChart(String currency) {
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra("url", "https://coinmarketcap.com/currencies/"+currency+"/#charts");
        startActivity(intent);
    }

    @Override
    public void setPresenter(MVPContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setText(String text) {
        TextView tv = root.findViewById(R.id.tv_last);
        tv.setText(text);
    }

    @Override
    public void setDesc(String text) {
        TextView tv = root.findViewById(R.id.tv_desc);
        tv.setText(text);
    }

    @Override
    public String getCurrency() {
        return etCurrency.getText().toString();
    }

    @Override
    public void disableButtons() {
        btnCheck.setEnabled(false);
        btnChart.setEnabled(false);
    }

    @Override
    public void enableButtons() {
        btnCheck.setEnabled(true);
        btnChart.setEnabled(true);
    }
}
