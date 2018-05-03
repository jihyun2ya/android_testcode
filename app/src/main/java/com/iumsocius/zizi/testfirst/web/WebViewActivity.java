package com.iumsocius.zizi.testfirst.web;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iumsocius.zizi.testfirst.R;
import com.iumsocius.zizi.testfirst.util.ActivityUtil;

/**
 * Created by zizi on 19/04/2018.
 */

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebViewFragment webViewFragment = (WebViewFragment) getSupportFragmentManager().findFragmentById(R.id.web_content_fragment);

        if (webViewFragment == null) {
            webViewFragment = new WebViewFragment();
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            webViewFragment.setArguments(extras);
        }

        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), webViewFragment, R.id.web_content_fragment);
    }
}
