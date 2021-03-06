package com.dy.mywanandroid.mvp.contract;

import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.MainBlogList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectDataList;
import com.dy.mywanandroid.mvp.http.entity.result.ProjectTypeList;
import com.haife.android.mcas.mvp.IModel;
import com.haife.android.mcas.mvp.IView;

import io.reactivex.Observable;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/23 0023 15:32
 */
public interface ManaggerContract  {
    interface View extends IView{
        /**
         * 获取项目分类
         * @param list
         */
        void getProjectType(ProjectTypeList list);

        /**
         * 获取项目数据
         * @param list
         */
        void getProjectData(MainBlogList list);

    }
    interface Model extends IModel{
        /**
         * 获取项目分类
         * @return
         */
        Observable<ProjectTypeList> getProjectType();

        /**
         * 获取项目数据
         * @param page
         * @param cid
         * @return
         */
        Observable<MainBlogList> getProjectData(int page,int cid);
        /**
         * 获取公众号分类列表
         * @return
         */
        Observable<ProjectTypeList> getAccountType();

        /**
         * 获取公众号数据
         * @param cid
         * @param page
         * @return
         */
        Observable<MainBlogList> getAccountData(int cid ,int page);
        /**
         * 收藏站内文章
         *
         * @param id
         * @return
         */
        Observable<BaseResponse> collection1(int id, String name, String pwd);

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
