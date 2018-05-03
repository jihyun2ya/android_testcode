package com.iumsocius.zizi.testfirst.web;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.iumsocius.zizi.testfirst.R;

/**
 * Created by zizi on 19/04/2018.
 */

public class WebViewFragment extends Fragment{

    public static final String URL = "url";
    public static final String DEFAULT_URL = "https://iumoffice.net/login";

    private View root;
    private WebView webView;
    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            url = args.getString(URL);
            if (url == null) {
                url = DEFAULT_URL;
            }
        } else {
            url = DEFAULT_URL;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_web, container, false);
        webView = root.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setSupportMultipleWindows(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);

        if (url == null || url.equals("")) {
            url = DEFAULT_URL;
        }
        webView.loadUrl(url);

        return root;
    }
}
