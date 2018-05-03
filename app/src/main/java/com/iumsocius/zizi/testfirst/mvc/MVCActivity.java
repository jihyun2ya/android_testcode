package com.iumsocius.zizi.testfirst.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iumsocius.zizi.testfirst.R;
import com.iumsocius.zizi.testfirst.data.MainData;

/**
 * Created by zizi on 18/04/2018.
 */

public class MVCActivity extends AppCompatActivity {

    private MainData data;
    private EditText et;
    private TextView tv;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.mvc);
        data = new MainData();
        data.getCoinArrayList();
        setContentView(R.layout.activity_mvc);

        tv = findViewById(R.id.mvc_tv_last);
        btn = findViewById(R.id.mvc_btn_check);
        btn.setOnClickListener(v -> {
            tv.setText(String.valueOf(data.getLastPrice(et.getText().toString())));
        });

        et = findViewById(R.id.mvc_et_currency);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    btn.setEnabled(false);
                } else {
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
