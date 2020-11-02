package com.dy.mywanandroid.mvp.ui.activity;

import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportActivity;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.utils.AppHelper;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebActivity extends BaseSupportActivity {

    @BindView(R.id.iv_back_web)
    ImageView ivBackWeb;
    @BindView(R.id.tv_title_web)
    TextView tvTitleWeb;
    @BindView(R.id.iv_menu_web)
    ImageView ivMenuWeb;

    @BindView(R.id.fl_wb)
    FrameLayout flWb;
    private AlertDialog alertDialog;
    private MainBlogList.DataBean.DatasBean datasBean;
    private CollectionResult.DataBean.DatasBean collBean;
    private WebView wvWeb;
    private QMUITipDialog dialog;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_web;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        QMUIStatusBarHelper.translucent(this);
        QMUIStatusBarHelper.setStatusBarDarkMode(this);
        QMUITipDialog.Builder builder = new QMUITipDialog.Builder(mContext);
        dialog = builder.setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING).setTipWord("加载中").create();
        dialog.show();
        // TODO: 2020/10/29 设置弹窗返回键失效 
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                    return true;
                }
                return false;
            }
        });
        flWb.setVisibility(View.GONE);
        wvWeb = new WebView(this);
        flWb.addView(wvWeb);
        wvWeb.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        flWb.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        ivBackWeb.setOnClickListener(v -> finish());
        wvWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (appInstalledOrNot(url)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else {
                    ToastUtils.showLong("手机上未安装打开此网页的应用");
                }
                return true;
            }
        });
        // TODO: 2020/10/29 加载进度
        wvWeb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100){
                    dialog.hide();
                    flWb.setVisibility(View.VISIBLE);
                }
            }
        });

        WebSettings webSettings = wvWeb.getSettings();
        // 让WebView能够执行javaScript
        webSettings.setJavaScriptEnabled(true);
        // 让JavaScript可以自动打开windows
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        // 设置缓存
        webSettings.setAppCacheEnabled(true);
        // 设置缓存模式,一共有四种模式
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        // 设置缓存路径
//        webSettings.setAppCachePath("");
        // 支持缩放(适配到当前屏幕)
        webSettings.setSupportZoom(true);
        // 将图片调整到合适的大小
        webSettings.setUseWideViewPort(true);
        // 支持内容重新布局,一共有四种方式
        // 默认的是NARROW_COLUMNS
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        // 设置可以被显示的屏幕控制
        webSettings.setDisplayZoomControls(true);
        // 设置默认字体大小
        if (getIntent().getSerializableExtra(AppHelper.MAIN_WEB_DATA) != null) {
            if (getIntent().getStringExtra(AppHelper.MAIN_WEB_TYPE) != null) {
                collBean = (CollectionResult.DataBean.DatasBean) getIntent().getSerializableExtra(AppHelper.MAIN_WEB_DATA);
                tvTitleWeb.setText(collBean.getTitle());
                wvWeb.loadUrl(collBean.getLink());
            } else {
                datasBean = (MainBlogList.DataBean.DatasBean) getIntent().getSerializableExtra(AppHelper.MAIN_WEB_DATA);
                tvTitleWeb.setText(datasBean.getTitle());
                wvWeb.loadUrl(datasBean.getLink());
            }
            //shouldOverrideUrlLoading(wvWeb,datasBean.getLink());
        }
    }

    @Override
    public void post(Runnable runnable) {

    }

    @OnClick({R.id.iv_menu_web, R.id.iv_back_web})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_web:
                finish();
                break;
            case R.id.iv_menu_web:
                showDialog();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (wvWeb.canGoBack()) {
                wvWeb.goBack(); //goBack()表示返回WebView的上一页面
                return true;
            } else {
                finish();
                return true;
            }

        }
        return false;
    }

    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.item_web_dialog, null);


        // TODO: 2020/9/23 0023 四个选项的点击事件
        FrameLayout flCopyLink = view.findViewById(R.id.fl_dialog_copy_link);
        FrameLayout flBrowser = view.findViewById(R.id.fl_open_browser);
        FrameLayout flShare = view.findViewById(R.id.fl_share);
        FrameLayout flRefresh = view.findViewById(R.id.fl_refresh);
        builder.setView(view);

        alertDialog = builder.create();
        alertDialog.show();
        Window window = alertDialog.getWindow();
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.mystyle);
        flCopyLink.setOnClickListener(onClickListener);
        flBrowser.setOnClickListener(onClickListener);
        flShare.setOnClickListener(onClickListener);
        flRefresh.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            if (datasBean == null) {
                return;
            }
            switch (v.getId()) {
                case R.id.fl_dialog_copy_link:
                    if (datasBean != null) {
                        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        cm.setText(datasBean.getLink());
                        ToastUtils.showLong("复制链接成功");
                    } else {
                        ToastUtils.showLong("复制链接失败");
                    }
                    break;
                case R.id.fl_open_browser:
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(datasBean.getLink()));
                    intent.setAction(Intent.ACTION_VIEW);
                    startActivity(intent);
                    break;
                case R.id.fl_share:

                    break;
                case R.id.fl_refresh:
                    wvWeb.loadUrl(datasBean.getLink());
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        wvWeb = null;
    }


}