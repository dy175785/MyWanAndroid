package com.dy.mywanandroid.mvp.http.api.service;

import com.blankj.utilcode.util.SPUtils;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.IntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.LoginResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.MyIntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.dy.mywanandroid.utils.AppHelper;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
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

    /**
     * 获取积分排行榜
     * @param page
     * @return
     */
    @GET("coin/rank/{page}/json")
    Observable<RankResultt> getRanking(@Path("page") int page);

    /**
     * 获取个人积分
     * @param page
     * @return
     */
    @GET("/lg/coin/list/{page}/json")
    Observable<IntegralResult> getIntegral(@Path("page") int page);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @POST("user/login")
    Observable<LoginResult> login(@Query("username")String username, @Query("password")String password);

    /**
     * 注册
     * @param username
     * @param password
     * @param repassword
     * @return
     */
    @POST("user/register")
    Observable<LoginResult> register(@Query("username")String username, @Query("password")String password,@Query("repassword")String repassword);

    /**
     * 收藏站内文章
     * @param id
     * @return
     */
    @POST("lg/collect/{id}/json")
    Observable<BaseResponse> collectionStationBlog(@Path("id") int id,@Header("Cookie") String name,@Header("Cookie") String pwd);

    /**
     * 收藏站外文章
     * @param title
     * @param author
     * @param link
     * @return
     */
    @POST("lg/collect/add/json")
    Observable<BaseResponse>collectionOutsideBlog(@Query("title")String title,@Query("author")String author,@Query("link")String link,@Header("Cookie") String name,@Header("Cookie") String pwd);

    /**
     * 取消收藏
     * @param id
     * @return
     */
    @POST("lg/uncollect_originId/{id}/json")
    Observable<BaseResponse>uncollectionBlog(@Path("id")int id,@Header("Cookie") String name,@Header("Cookie") String pwd);

    /**
     * 获取个人积分
     * @return
     */
//    @Headers({
//            "Cookie: loginUserName=",
//            "Cookie: loginUserPassword=qwe282937"
//    })
    @GET("lg/coin/userinfo/json")
    Observable<MyIntegralResult>getMyIntegral(@Header("Cookie") String name,@Header("Cookie") String pwd);

    /**
     * 退出登录
     * @return
     */
    @GET("user/logout/json")
    Observable<BaseResponse> outLogin();

    /**
     * 获取收藏列表
     * @param page
     * @return
     */
    @GET("lg/collect/list/{page}/json")
    Observable<CollectionResult> getColl(@Path("page")int page, @Header("Cookie") String name, @Header("Cookie") String pwd);
}
