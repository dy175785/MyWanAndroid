package com.dy.mywanandroid.mvp.contract;

import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.dy.mywanandroid.mvp.http.entity.result.CollectionResult;
import com.dy.mywanandroid.mvp.http.entity.result.IntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.MyIntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.haife.android.mcas.mvp.IModel;
import com.haife.android.mcas.mvp.IView;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Header;

public interface MyContract {

    interface View extends IView{
        /**
         * 获取积分排行榜
         * @param resultt
         */
        void getRanking(RankResultt resultt);

        void getIntegral(RankResultt resultt);

        /**
         * 获取个人的积分
         * @param result
         */
        void getMyIntegral(MyIntegralResult result);

        /**
         * 退出登录
         * @param response
         */
        void outLogin(BaseResponse response);

        /**
         * 获取我的收藏列表
         * @param result
         */
        void getColl(CollectionResult result);
    }

    interface Model extends IModel{
        /**
         * 获取积分排行榜
         * @param page
         * @return
         */
        Observable<RankResultt> getRanking(int page);

        /**
         * 获取个人积分列表
         * @return
         */
        Observable<IntegralResult> getIntegral(int page);

        /**
         * 获取个人积分
         * @return
         */
        Observable<MyIntegralResult> getMyIntegral(String name,String pwd);

        /**
         * 退出登录
         * @return
         */
        Observable<BaseResponse> outLogin();

        /**
         * 获取收藏列表
         * @return
         */
        Observable<CollectionResult> getColl(int page, String name, String pwd);
        /**
         * 取消收藏
         *
         * @param id
         * @return
         */
        Observable<BaseResponse> uncollection(int id, String name, String pwd);
    }

}
