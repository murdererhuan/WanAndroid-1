package com.allen.wanandroid.ui.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.allen.wanandroid.R;
import com.allen.wanandroid.constant.BundleKey;
import com.allen.wanandroid.ui.presenter.WebViewPresenter;
import com.allen.wanandroid.ui.view.WebViewView;
import com.library.base.mvp.BaseMvpActivity;
import com.library.base.widget.TopBar;

import butterknife.BindView;

/**
 * <pre>
 *      @author : Allen
 *      e-mail  : lygttpod@163.com
 *      date    : 2018/07/22
 *      desc    :
 *      version : 1.0
 * </pre>
 */
public class WebViewActivity extends BaseMvpActivity<WebViewPresenter> implements WebViewView {
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private String title;
    private String url;

    @Override
    protected void getBundleData(Bundle params) {
        title = params.getString(BundleKey.TITLE);
        url = params.getString(BundleKey.URL);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_webview;
    }

    @Override
    public void setTopBar(TopBar topBar) {
        topBar.setLeftText(title);
    }

    @Override
    public boolean isCanRefresh() {
        return false;
    }

    @Override
    public void doOnRefresh() {

    }

    @Override
    public void doBusiness(Context context) {
        mPresenter.loadUrl(webView,url);
    }

    @Override
    public ProgressBar getProgressBar() {
        return progressBar;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    protected WebViewPresenter createPresenter() {
        return new WebViewPresenter();
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
