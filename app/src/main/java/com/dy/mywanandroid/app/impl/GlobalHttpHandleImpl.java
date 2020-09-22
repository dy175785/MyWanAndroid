package com.dy.mywanandroid.app.impl;

import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.dy.mywanandroid.mvp.http.entity.base.BaseResponse;
import com.haife.android.mcas.http.GlobalHttpHandler;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author dengyong
 * @Date 2020-05-19
 * @dec
 */
public class GlobalHttpHandleImpl implements GlobalHttpHandler {
    private Context context;

    public GlobalHttpHandleImpl(Context context) {
        this.context = context;
    }

    /**
     * 这里可以先客户端一步拿到每一次 Http 请求的结果, 可以先解析成 Json, 再做一些操作, 如检测到 token 过期后
     * 重新请求 token, 并重新执行请求
     *
     * @param httpResult 服务器返回的结果 (已被框架自动转换为字符串)
     * @param chain      {@link Interceptor.Chain}
     * @param response   {@link Response}
     * @return
     */
    @Override
    public Response onHttpResultResponse(String httpResult, Interceptor.Chain chain, Response response) {
        //判断token是否失效，失效了就要重新登录
        //先判断是否有返回结果，否则没有结果后面会报空指针
        if(!TextUtils.isEmpty(httpResult)) {
            BaseResponse baseResponse = null;
            try {
                baseResponse = JSONObject.parseObject(httpResult, BaseResponse.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return response;
    }




    /**
     * 这里可以在请求服务器之前拿到 {@link Request}, 做一些操作比如给 {@link Request} 统一添加 token 或者 header 以及参数加密等操作
     *
     * @param chain   {@link Interceptor.Chain}
     * @param request {@link Request}
     * @return
     */
    @Override
    public Request onHttpRequestBefore(Interceptor.Chain chain, Request request) {
        //存放token 把token当头部发送过去
        String token = "";//SPUtils.getInstance().getString(SPParam.SP_LOGIN_TOKEN)
        return chain.request().newBuilder().addHeader("Cookie", token).build();

    }
}
