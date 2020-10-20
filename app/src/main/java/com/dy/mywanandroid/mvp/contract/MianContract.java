package com.dy.mywanandroid.mvp.contract;

import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.LoginResult;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.haife.android.mcas.mvp.IModel;
import com.haife.android.mcas.mvp.IView;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Header;

/**
 * Administrator
 *
 * @author dy
 * created at 2020/9/21 0021 15:35
 */
public interface MianContract {
    interface View extends IView {
        /**
         * banner
         *
         * @param list
         */
        void getBanner(BannerList list);

        /**
         * blog
         *
         * @param list
         */
        void getBlogList(MainBlogList list);

        /**
         * 注册成功
         */
        void registerSuccess();
    }

    interface Model extends IModel {
        /**
         * 获取首页文章列表
         *
         * @param page
         * @return
         */
        Observable<MainBlogList> getBlogList(int page);

        /**
         * 获取首页banner
         *
         * @return
         */
        Observable<BannerList> getBanner();

        /**
         * 登录
         *
         * @param name
         * @param pwd
         * @return
         */
        Observable<LoginResult> login(String name, String pwd);

        /**
         * 注册
         *
         * @param name
         * @param pwd
         * @param repwd
         * @return
         */
        Observable<LoginResult> register(String name, String pwd, String repwd);

        /**
         * 收藏站内文章
         *
         * @param id
         * @return
         */
        Observable<BaseResponse> collection1(int id,  String name, String pwd);

        /**
         * 收藏站外文章
         *
         * @param title
         * @param author
         * @param link
         * @return
         */
        Observable<BaseResponse> collection2(String title, String author, String link, String name, String pwd);

        /**
         * 取消收藏
         *
         * @param id
         * @return
         */
        Observable<BaseResponse> uncollection(int id, String name, String pwd);
    }
}
