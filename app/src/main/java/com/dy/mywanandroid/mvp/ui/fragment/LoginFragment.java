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
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.presenter.MainPresenter;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginFragment extends BaseSupportFragment<MainPresenter> implements MianContract.View {


    @BindView(R.id.editTextPhone)
    EditText editTextPhone;
    @BindView(R.id.editTextNumberPassword)
    EditText editTextNumberPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_password)
    Button btnPassword;
    @BindView(R.id.editRePassword)
    EditText editRePassword;
    private QMUITipDialog dialog;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

        return fragment;
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

    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @OnClick({R.id.btn_login, R.id.btn_password})
    public void onClick(View view) {
        String name = editTextPhone.getText().toString().trim();
        String pwd = editTextNumberPassword.getText().toString().trim();

        switch (view.getId()) {
            case R.id.btn_login:
                if (TextUtils.isEmpty(name)) {
                    ToastUtils.showLong("请输入账号");
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    ToastUtils.showLong("请输入密码");
                }
                showLoading();
                mPresenter.login(name, pwd);
                break;
            case R.id.btn_password:
//                editRePassword.setVisibility(View.VISIBLE);
//                String repwd = editRePassword.getText().toString().trim();
//                btnLogin.setVisibility(View.GONE);
//                if (TextUtils.isEmpty(repwd)){
//                    ToastUtils.showLong("请确认密码");
//                    return;
//                }
//                if (!pwd.equals(repwd)){
//                    ToastUtils.showLong("两次密码不一致，请重新输入");
//                    return;
//                }
//                showLoading();
                start(RegisterFragment.getInstance());
                break;
            default:
                break;
        }
    }

    @Override
    public void getBanner(BannerList list) {

    }

    @Override
    public void getBlogList(MainBlogList list) {

    }

    @Override
    public void registerSuccess() {
        btnLogin.setVisibility(View.VISIBLE);
        editRePassword.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }

    @Override
    public void showLoading() {
        QMUITipDialog.Builder builder = new QMUITipDialog.Builder(mContext);
        dialog = builder.setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING).create();
        dialog.show();
    }

    @Override
    public void hideLoading() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public void killMyself() {
        getActivity().finish();
    }
}