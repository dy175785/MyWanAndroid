package com.dy.mywanandroid.mvp.presenter;

import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.haife.android.mcas.mvp.BasePresenter;
import com.haife.android.mcas.utils.RxLifecycleUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

/**
 * Administrator
 *
 * @author dy
 * created at 2020/9/21 0021 15:37
 */
public class MainPresenter extends BasePresenter<MianContract.Model, MianContract.View> {
    @Inject
    RxErrorHandler mErrorHandler;

    @Inject
    public MainPresenter(MianContract.Model model, MianContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 获取首页文章
     *
     * @param page
     */
    public void getBlog(int page) {
        mModel.getBlogList(page)
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<MainBlogList>(mErrorHandler) {
                    @Override
                    public void onNext(MainBlogList mainBlogList) {
                        if (mainBlogList.getErrorCode() == 0) {
                            mRootView.getBlogList(mainBlogList);
                        } else {
                            mRootView.getBlogList(null);
                        }
                    }
                });
    }

    /**
     * 获取首页banner
     */
    public void getBanner() {
        mModel.getBanner().subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<BannerList>(mErrorHandler) {
                    @Override
                    public void onNext(BannerList bannerList) {
                        if (bannerList.getErrorCode() == 0) {
                            mRootView.getBanner(bannerList);
                        } else {
                            mRootView.getBanner(null);
                        }
                    }
                });
    }
}
