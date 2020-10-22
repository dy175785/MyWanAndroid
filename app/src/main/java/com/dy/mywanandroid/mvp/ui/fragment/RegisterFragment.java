package com.dy.mywanandroid.mvp.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportFragment;
import com.dy.mywanandroid.di.component.DaggerMainComponent;
import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.presenter.MainPresenter;
import com.haife.android.mcas.di.component.AppComponent;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterFragment extends BaseSupportFragment<MainPresenter> implements MianContract.View {

    @BindView(R.id.editTextPhone)
    EditText editTextPhone;
    @BindView(R.id.editTextNumberPassword)
    EditText editTextNumberPassword;
    @BindView(R.id.editRePassword)
    EditText editRePassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_password)
    Button btnPassword;

    public static RegisterFragment getInstance() {
        return new RegisterFragment();
    }

    @Override
    public void getBanner(BannerList list) {

    }

    @Override
    public void getBlogList(MainBlogList list) {

    }

    @Override
    public void registerSuccess() {
        getActivity().onBackPressed();
    }

    @Override
    public void getColl(CollectionResult result) {

    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent.builder()
                .view(this)
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        btnLogin.setVisibility(View.GONE);
        editRePassword.setVisibility(View.VISIBLE);
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @OnClick({R.id.btn_password})
    public void onClick(View view) {
        String name = editTextPhone.getText().toString().trim();
        String pwd = editTextNumberPassword.getText().toString().trim();
        if (TextUtils.isEmpty(name)) {
            ToastUtils.showLong("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.showLong("请输入密码");
        }
        switch (view.getId()) {
            case R.id.btn_password:
                editRePassword.setVisibility(View.VISIBLE);
                String repwd = editRePassword.getText().toString().trim();
                btnLogin.setVisibility(View.GONE);
                if (TextUtils.isEmpty(repwd)){
                    ToastUtils.showLong("请确认密码");
                    return;
                }
                if (!pwd.equals(repwd)){
                    ToastUtils.showLong("两次密码不一致，请重新输入");
                    return;
                }
                showLoading();
                mPresenter.register(name,pwd,repwd);
                break;
            default:
                break;
        }
    }
}
