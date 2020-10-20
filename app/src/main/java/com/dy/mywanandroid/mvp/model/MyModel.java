package com.dy.mywanandroid.mvp.model;

import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.http.api.service.CommonService;
import com.dy.mywanandroid.mvp.http.entity.result.IntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.haife.android.mcas.di.scope.ActivityScope;
import com.haife.android.mcas.integration.IRepositoryManager;
import com.haife.android.mcas.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

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
}
