package com.dy.mywanandroid.mvp.model;

import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.http.api.service.CommonService;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.LoginResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.haife.android.mcas.di.scope.ActivityScope;
import com.haife.android.mcas.integration.IRepositoryManager;
import com.haife.android.mcas.mvp.BaseModel;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/21 0021 15:36
 */
@ActivityScope
public class MainModel extends BaseModel implements MianContract.Model {
    @Inject
    public MainModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    @Override
    public Observable<MainBlogList> getBlogList(int page) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getMainBlog(page)).flatMap((Function<Observable<MainBlogList>, ObservableSource<MainBlogList>>) mainBlogListObservable -> mainBlogListObservable);
    }

    @Override
    public Observable<BannerList> getBanner() {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getBanner()).flatMap((Function<Observable<BannerList>, ObservableSource<BannerList>>) bannerListObservable -> bannerListObservable);
    }

    @Override
    public Observable<LoginResult> login(String name, String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).login(name, pwd)).flatMap((Function<Observable<LoginResult>, ObservableSource<LoginResult>>) loginResultObservable -> loginResultObservable);
    }

    @Override
    public Observable<LoginResult> register(String name, String pwd, String repwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).register(name, pwd, repwd)).flatMap((Function<Observable<LoginResult>, ObservableSource<LoginResult>>) loginResultObservable -> loginResultObservable);
    }

    @Override
    public Observable<BaseResponse> collection1(int id, Map<String,String> map) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).collectionStationBlog(id,map)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }

    @Override
    public Observable<BaseResponse> collection2(String title, String author, String link, Map<String,String> map) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).collectionOutsideBlog(title, author, link,map)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }

    @Override
    public Observable<BaseResponse> uncollection(int id, Map<String,String> map) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).uncollectionBlog(id,map)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }
}
