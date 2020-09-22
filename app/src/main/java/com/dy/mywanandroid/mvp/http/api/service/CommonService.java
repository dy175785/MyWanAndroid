package com.dy.mywanandroid.mvp.http.api.service;

import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *  数据公共接口
 *  @author dy
 *  created at 2020/9/21 0021 15:59
 */
public interface CommonService {
    /**
     * 获取首页banner
     * @return
     */
    @GET("banner/json")
    Observable<BannerList> getBanner();

    /**
     * 获取首页文章列表
     * @param page
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<MainBlogList> getMainBlog(@Path("page") int page);

}
