package com.dy.mywanandroid.mvp.presenter;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.LoginResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.utils.AppHelper;
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

    /**
     * 登录
     * @param name
     * @param pwd
     */
    public void login(String name,String pwd){
        mModel.login(name, pwd)
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<LoginResult>(mErrorHandler) {
                    @Override
                    public void onNext(LoginResult loginResult) {
                        mRootView.hideLoading();
                        if (loginResult.getErrorCode() == 0){
                            SPUtils.getInstance().put(AppHelper.LOGIN_USER_USERNAME,name);
                            SPUtils.getInstance().put(AppHelper.LOGIN_USER_PASSWORD,pwd);
                            mRootView.killMyself();
                        }else {
                            ToastUtils.showLong("登录失败");
                        }
                    }
                });
    }

    /**
     * 注册
     * @param name
     * @param pwd
     * @param repwd
     */
    public void register(String name,String pwd,String repwd){
        mModel.register(name, pwd, repwd)
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<LoginResult>(mErrorHandler) {
                    @Override
                    public void onNext(LoginResult loginResult) {
                        mRootView.hideLoading();
                        if (loginResult.getErrorCode() == 0){
                            mRootView.registerSuccess();
                        }else {
                            ToastUtils.showLong("注册失败："+loginResult.getErrorMsg());
                        }
                    }
                });
    }

    /**
     * 收藏站内文章
     * @param id
     */
    public void collectionWithin(int id){
        mModel.collection1(id,AppHelper.getNameCookie(),AppHelper.getPwdCookie())
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<BaseResponse>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        if (baseResponse.getErrorCode() == 0){

                        }else {

                        }
                    }
                });
    }

    /**
     * 收藏站外的文章
     * @param title
     * @param author
     * @param link
     */
    public void collectionExternal(String title,String author,String link){
        mModel.collection2(title, author, link,AppHelper.getNameCookie(),AppHelper.getPwdCookie())
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<BaseResponse>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        if (baseResponse.getErrorCode() == 0){

                        }else {

                        }
                    }
                });
    }

    /**
     * 取消收藏
     * @param id
     */
    public void unCollection(int id){
        mModel.uncollection(id,AppHelper.getNameCookie(),AppHelper.getPwdCookie())
                .subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<BaseResponse>(mErrorHandler) {
                    @Override
                    public void onNext(BaseResponse baseResponse) {
                        if (baseResponse.getErrorCode() == 0){

                        }else {

                        }
                    }
                });
    }

}
