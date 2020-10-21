package com.dy.mywanandroid.mvp.model;

import com.dy.mywanandroid.mvp.contract.ManaggerContract;
import com.dy.mywanandroid.mvp.http.api.service.CommonService;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.haife.android.mcas.di.scope.ActivityScope;
import com.haife.android.mcas.integration.IRepositoryManager;
import com.haife.android.mcas.mvp.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

@ActivityScope
public class ManaggerModel extends BaseModel implements ManaggerContract.Model {

    @Inject
    public ManaggerModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }

    /**
     * 获取项目分类
     *
     * @return
     */
    @Override
    public Observable<ProjectTypeList> getProjectType() {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getProjectType()).flatMap((Function<Observable<ProjectTypeList>, ObservableSource<ProjectTypeList>>) projectTypeListObservable -> projectTypeListObservable);
    }

    /**
     * 获取项目数据
     * @param page
     * @param cid
     * @return
     */
    @Override
    public Observable<MainBlogList> getProjectData(int page, int cid) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getProjectData(page, cid)).flatMap((Function<Observable<MainBlogList>, ObservableSource<MainBlogList>>) projectDataListObservable -> projectDataListObservable);
    }

    /**
     * 获取公众号列表数据
     * @return
     */
    @Override
    public Observable<ProjectTypeList> getAccountType() {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getAccountType()).flatMap((Function<Observable<ProjectTypeList>, ObservableSource<ProjectTypeList>>) projectTypeListObservable -> projectTypeListObservable);
    }

    /**
     *
     * @param cid
     * @param page
     * @return
     */
    @Override
    public Observable<MainBlogList> getAccountData(int cid, int page) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).getAccountData(cid, page)).flatMap((Function<Observable<MainBlogList>, ObservableSource<MainBlogList>>) mainBlogListObservable -> mainBlogListObservable);
    }

    @Override
    public Observable<BaseResponse> collection1(int id, String name, String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).collectionStationBlog(id,name,pwd)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }

    @Override
    public Observable<BaseResponse> collection2(String title, String author, String link, String name, String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).collectionOutsideBlog(title, author, link,name,pwd)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }

    @Override
    public Observable<BaseResponse> uncollection(int id, String name, String pwd) {
        return Observable.just(mRepositoryManager.obtainRetrofitService(CommonService.class).uncollectionBlog(id,name,pwd)).flatMap((Function<Observable<BaseResponse>, ObservableSource<BaseResponse>>) baseResponseObservable -> baseResponseObservable);
    }
}
