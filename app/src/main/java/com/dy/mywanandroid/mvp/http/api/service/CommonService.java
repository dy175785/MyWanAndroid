package com.dy.mywanandroid.mvp.http.api.service;

import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

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

    /**
     * 获取项目分类
     * @return
     */
    @GET("project/tree/json")
    Observable<ProjectTypeList> getProjectType();

    /**
     * 获取项目数据
     * @param page
     * @param cid
     * @return
     */
    @GET("project/list/{page}/json")
    Observable<MainBlogList> getProjectData(@Path("page") int page, @Query("cid") int cid);
    /**
     * 获取公众号分类列表
     * @return
     */
    @GET("wxarticle/chapters/json")
    Observable<ProjectTypeList> getAccountType();

    /**
     * 获取项目数据
     * @param page
     * @param cid
     * @return
     */
    @GET("wxarticle/list/{cid}/{page}/json")
    Observable<MainBlogList> getAccountData(@Path("cid") int cid,@Path("page") int page );
}
