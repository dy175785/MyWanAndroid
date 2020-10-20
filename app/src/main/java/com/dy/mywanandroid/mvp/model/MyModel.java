package com.dy.mywanandroid.mvp.model;

import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.http.api.service.CommonService;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.IntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.MyIntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.haife.android.mcas.di.scope.ActivityScope;
import com.haife.android.mcas.integration.IRepositoryManager;
import com.haife.android.mcas.mvp.BaseModel;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import retrofit2.http.Header;

@ActivityScope
public class MyModel extends BaseModel implements MyContract.Model {
    @Inject
    public MyModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    /**
     * 获取积分排行榜
     * @param page
     * @return
     */
    @Override
    public Observable<RankResultt> getRanking(int page) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getRanking(page)).flatMap((Function<Observable<RankResultt>, ObservableSource<RankResultt>>) rankResulttObservable -> rankResulttObservable);
    }

    /**
     * 获取个人积分列表
     * @param page
     * @return
     */
    @Override
    public Observable<IntegralResult> getIntegral(int page) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getIntegral(page)).flatMap((Function<Observable<IntegralResult>, ObservableSource<IntegralResult>>) integralResultObservable -> integralResultObservable);
    }

    /**
     * 获取我的积分
     * @return
     */
    @Override
    public Observable<MyIntegralResult> getMyIntegral(String name,String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getMyIntegral(name, pwd)).flatMap((Function<Observable<MyIntegralResult>, ObservableSource<MyIntegralResult>>) myIntegralResultObservable -> myIntegralResultObservable);
    }

    /**
     * 退出登录
     * @return
     */
    @Override
    public Observable<BaseResponse> outLogin() {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).outLogin()).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }

    @Override
    public Observable<CollectionResult> getColl(int page, String name, String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getColl(page,name,pwd)).flatMap((Function<Observable<CollectionResult>, ObservableSource<CollectionResult>>) observable -> observable);
    }

    /**
     * 取消收藏
     * @param id
     * @param name
     * @param pwd
     * @return
     */
    @Override
    public Observable<BaseResponse> uncollection(int id, String name, String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).uncollectionBlog(id, name, pwd)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }
}
