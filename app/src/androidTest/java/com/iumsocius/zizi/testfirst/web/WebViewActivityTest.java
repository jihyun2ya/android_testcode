package com.iumsocius.zizi.testfirst.web;

import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.web.assertion.WebViewAssertions.webMatches;
import static android.support.test.espresso.web.model.Atoms.getCurrentUrl;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.clearElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.getText;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by zizi on 19/04/2018.
 */

public class WebViewActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(WebViewActivity.class);

    @Before
    public void init(){
        UiDevice uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        try {
            if (!uiDevice.isScreenOn()) {
                uiDevice.wakeUp();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void typeTextInInput_clickButton_SubmitsForm() {

        // Selects the WebView in your layout.
        // If you have multiple WebViews you can also use a
        // matcher to select a given WebView, onWebView(withId(R.id.web_view)).
        onWebView()
                .withNoTimeout()
                // Check current url
                .check(webMatches(getCurrentUrl(), containsString(WebViewFragment.DEFAULT_URL)))
                // Find the input element by ID
                .withElement(findElement(Locator.ID, "input_login_email"))
                // Clear previous input
                .perform(clearElement())
                // Enter text into the input element
                .perform(DriverAtoms.webKeys("jihyun2yo@gmail.com"));

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onWebView().withElement(findElement(Locator.XPATH, "//*[@id=\"login_button\"]"))
                // Simulate a click via JavaScript
                .perform(webClick())
                // Find the response element by ID
                .withElement(findElement(Locator.CLASS_NAME, "error_txt"))
                // Verify that the response page contains the entered text
                .check(webMatches(getText(), containsString("비밀번호가 일치하지 않습니다.")));

    }
}