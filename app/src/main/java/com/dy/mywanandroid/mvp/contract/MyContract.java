package com.dy.mywanandroid.mvp.contract;

import com.dy.mywanandroid.mvp.http.entity.result.IntegralResult;
import com.dy.mywanandroid.mvp.http.entity.result.RankResultt;
import com.haife.android.mcas.mvp.IModel;
import com.haife.android.mcas.mvp.IView;

import io.reactivex.Observable;

public interface MyContract {

    interface View extends IView{
        /**
         * 获取积分排行榜
         * @param resultt
         */
        void getRanking(RankResultt resultt);

        void getIntegral(RankResultt resultt);
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

    }

}
