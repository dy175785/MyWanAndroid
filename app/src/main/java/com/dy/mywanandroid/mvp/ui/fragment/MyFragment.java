package com.dy.mywanandroid.mvp.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dy.mywanandroid.R;
import com.dy.mywanandroid.app.base.BaseSupportFragment;
import com.dy.mywanandroid.di.component.DaggerMyComponent;
import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.MyIntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.dy.mywanandroid.mvp.presenter.MyPresenter;
import com.dy.mywanandroid.mvp.ui.activity.LoginActivity;
import com.dy.mywanandroid.mvp.ui.activity.RankingActivity;
import com.dy.mywanandroid.mvp.ui.custom.MergeLayout;
import com.dy.mywanandroid.utils.AppHelper;
import com.haife.android.mcas.di.component.AppComponent;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的
 *
 * @author dy
 * created at 2020/9/21 0021 14:24
 */
public class MyFragment extends BaseSupportFragment<MyPresenter> implements MyContract.View {

    @BindView(R.id.qtb_my)
    QMUITopBar qtbMy;
    @BindView(R.id.iv_my_img)
    ImageView ivMyImg;
    @BindView(R.id.tv_my_name)
    TextView tvMyName;
    @BindView(R.id.ml_integral)
    MergeLayout mlIntegral;
    @BindView(R.id.ml_collection)
    MergeLayout mlCollection;
    @BindView(R.id.btn_out)
    Button btnOut;

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerMyComponent.builder().view(this).appComponent(appComponent).build().inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity(), RankingActivity.class);
        qtbMy.setTitle("我的").setTextColor(Color.WHITE);
        qtbMy.addRightImageButton(R.mipmap.icon_ranking, R.id.qtb_my).setOnClickListener(v -> {
            intent.putExtra(AppHelper.MY_INTENT_DATA, 0);
            startActivity(intent);
        });
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void post(Runnable runnable) {

    }

    @Override
    public void showMessage(@NonNull String message) {

    }

    @Override
    public void showQMUITipDialog(String msg, int iconType) {

    }

    @Override
    public void getRanking(RankResultt resultt) {

    }

    @Override
    public void getIntegral(RankResultt resultt) {

    }

    @Override
    public void getMyIntegral(MyIntegralResult result) {
        if (result.getErrorCode() == 0) {
            ToastUtils.showLong("你的总积分是：" + result.getData().getCoinCount() + ",当前排名是：" + result.getData().getRank());
        } else {
            ToastUtils.showLong(result.getErrorMsg());
        }

    }

    @Override
    public void outLogin(BaseResponse response) {
        if (response.getErrorCode() == 0){
            SPUtils.getInstance().clear();
        }
    }

    @Override
    public void getColl(CollectionResult result) {

    }

    @OnClick({R.id.tv_my_name, R.id.iv_my_img, R.id.ml_integral, R.id.ml_collection,R.id.btn_out})
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), RankingActivity.class);
        switch (view.getId()) {
            case R.id.iv_my_img:
            case R.id.tv_my_name:
                if (TextUtils.isEmpty(SPUtils.getInstance().getString(AppHelper.LOGIN_USER_USERNAME))) {
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
                break;
            case R.id.ml_integral:
                if (!TextUtils.isEmpty(SPUtils.getInstance().getString(AppHelper.LOGIN_USER_USERNAME))) {
                    mPresenter.getMyIntegral();
                } else {
                    ToastUtils.showLong(R.string.app_no_login);
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }

                break;
            case R.id.ml_collection:
                if (!TextUtils.isEmpty(SPUtils.getInstance().getString(AppHelper.LOGIN_USER_USERNAME))) {
                    intent.putExtra(AppHelper.MY_INTENT_DATA, 2);
                    startActivity(intent);
                } else {
                    ToastUtils.showLong(R.string.app_no_login);
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                }
                break;
            case R.id.btn_out:
                mPresenter.outLogin();
                break;
            default:
                break;
        }
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        String name = SPUtils.getInstance().getString(AppHelper.LOGIN_USER_USERNAME);
        if (!TextUtils.isEmpty(name)) {
            tvMyName.setText(name);
            btnOut.setVisibility(View.VISIBLE);
        }else {
            btnOut.setVisibility(View.GONE);
        }
    }
}