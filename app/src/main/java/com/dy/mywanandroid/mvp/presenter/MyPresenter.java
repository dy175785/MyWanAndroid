package com.dy.mywanandroid.mvp.presenter;

import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.http.entity.result.IntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.haife.android.mcas.mvp.BasePresenter;
import com.haife.android.mcas.utils.RxLifecycleUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

public class MyPresenter extends BasePresenter<MyContract.Model,MyContract.View> {
    @Inject
    RxErrorHandler mRxErrorHandler;
    @Inject
    public MyPresenter(MyContract.Model model, MyContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 获取积分排行榜
     * @param page
     */
    public void getRanking(int page){
        mModel.getRanking(page)
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mRootView.hideLoading())
                .subscribe(new ErrorHandleSubscriber<RankResultt>(mRxErrorHandler) {
                    @Override
                    public void onNext(RankResultt rankResultt) {
                        if (rankResultt.getErrorCode() == 0){
                            mRootView.getRanking(rankResultt);
                        }else {
                            mRootView.getRanking(null);
                        }
                    }
                });
    }

    /**
     * 获取各人积分列表
     * @param page
     */
    public void getIntegral(int page){
        mModel.getIntegral(page)
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> mRootView.hideLoading())
                .subscribe(new ErrorHandleSubscriber<IntegralResult>(mRxErrorHandler) {
                    @Override
                    public void onNext(IntegralResult integralResult) {
                        if (integralResult.getErrorCode() == 0){

                        }else {

                        }
                    }
                });
    }

}
