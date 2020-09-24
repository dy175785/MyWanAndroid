package com.dy.mywanandroid.mvp.presenter;

import com.dy.mywanandroid.mvp.contract.ManaggerContract;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.haife.android.mcas.mvp.BasePresenter;
import com.haife.android.mcas.utils.RxLifecycleUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/23 0023 15:34
 */
public class ManaggerPresenter extends BasePresenter<ManaggerContract.Model,ManaggerContract.View> {
    @Inject
    RxErrorHandler mRxErrorHandler;
    @Inject
    public ManaggerPresenter(ManaggerContract.Model model, ManaggerContract.View rootView) {
        super(model, rootView);
    }

    /**
     * 获取项目分类
     */
    public void getProjectType(){
        mModel.getProjectType().subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<ProjectTypeList>(mRxErrorHandler) {
                    @Override
                    public void onNext(ProjectTypeList projectTypeList) {
                        if (projectTypeList.getErrorCode() == 0){
                            mRootView.getProjectType(projectTypeList);
                        }else {
                            mRootView.getProjectType(null);
                        }
                    }
                });
    }

    /**
     * 获取项目数据
     * @param page
     * @param cid
     */
    public void getProjectData(int page,int cid){
        mModel.getProjectData(page, cid).subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<MainBlogList>(mRxErrorHandler) {
                    @Override
                    public void onNext(MainBlogList projectDataList) {
                        if (projectDataList.getErrorCode()==0){
                            mRootView.getProjectData(projectDataList);
                        }else {
                            mRootView.getProjectData(null);
                        }
                    }
                });
    }

    /**
     * 获取公众号列表分类
     */
    public void getAccountType(){
        mModel.getAccountType().subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<ProjectTypeList>(mRxErrorHandler) {
                    @Override
                    public void onNext(ProjectTypeList projectTypeList) {
                        if (projectTypeList.getErrorCode() == 0){
                            mRootView.getProjectType(projectTypeList);
                        }else {
                            mRootView.getProjectType(null);
                        }
                    }
                });
    }

    /**
     * 获取公众号内数据
     * @param cid
     * @param page
     */
    public void getaccountData(int cid,int page){
        mModel.getAccountData(cid, page).subscribeOn(Schedulers.io())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ErrorHandleSubscriber<MainBlogList>(mRxErrorHandler) {
                    @Override
                    public void onNext(MainBlogList list) {
                        if (list.getErrorCode() == 0){
                            mRootView.getProjectData(list);
                        }else {
                            mRootView.getProjectData(null);
                        }
                    }
                });
    }
}
