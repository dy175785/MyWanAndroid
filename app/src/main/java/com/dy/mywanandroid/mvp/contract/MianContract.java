package com.dy.mywanandroid.mvp.contract;

import com.dy.mywanandroid.mvp.http.entity.result.BannerList;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.haife.android.mcas.mvp.IModel;
import com.haife.android.mcas.mvp.IView;

import io.reactivex.Observable;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/21 0021 15:35
 */
public interface MianContract {
    interface View extends IView{
        /**
         * banner
         * @param list
         */
        void getBanner(BannerList list);

        /**
         * blog
         * @param list
         */
        void getBlogList(MainBlogList list);
    }

    interface Model extends IModel{
        /**
         * 获取首页文章列表
         * @param page
         * @return
         */
        Observable<MainBlogList> getBlogList(int page);

        /**
         * 获取首页banner
         * @return
         */
        Observable<BannerList> getBanner();
    }
}
