package org.grabski.focus.helpers;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;
import org.grabski.focus.R;
import org.grabski.focus.web.IWebView;
import org.grabski.focus.webview.SystemWebView;

public class WebViewFakeLongPress implements ViewAction {
    public static ViewAction injectHitTarget(IWebView.HitTarget hitTarget) {
        return new WebViewFakeLongPress(hitTarget);
    }

    private IWebView.HitTarget hitTarget;

    private WebViewFakeLongPress(IWebView.HitTarget hitTarget) {
        this.hitTarget = hitTarget;
    }

    @Override
    public Matcher<View> getConstraints() {
        return ViewMatchers.withId(R.id.webview);
    }

    @Override
    public String getDescription() {
        return "Long pressing webview";
    }

    @Override
    public void perform(UiController uiController, View view) {
        final SystemWebView webView = (SystemWebView) view;

        webView.getCallback()
                .onLongPress(hitTarget);
    }
}
