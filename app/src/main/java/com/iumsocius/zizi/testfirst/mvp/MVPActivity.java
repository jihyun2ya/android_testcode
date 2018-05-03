package com.iumsocius.zizi.testfirst.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iumsocius.zizi.testfirst.R;
import com.iumsocius.zizi.testfirst.util.ActivityUtil;

public class MVPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.mvp);
        setContentView(R.layout.activity_main);

        MVPFragment MVPFragment = (MVPFragment) getSupportFragmentManager().findFragmentById(R.id.main_content_fragment);

        if (MVPFragment == null) {
            MVPFragment = new MVPFragment();
        }

        MVPPresenter presenter = new MVPPresenter();
        MVPFragment.setPresenter(presenter);
        presenter.setView(MVPFragment);

        ActivityUtil.addFragmentToActivity(getSupportFragmentManager(), MVPFragment, R.id.main_content_fragment);
    }
}
