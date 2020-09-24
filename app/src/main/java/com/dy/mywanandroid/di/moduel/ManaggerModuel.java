package com.dy.mywanandroid.di.moduel;

import com.dy.mywanandroid.mvp.contract.ManaggerContract;
import com.dy.mywanandroid.mvp.model.ManaggerModel;

import dagger.Binds;
import dagger.Module;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/23 0023 15:35
 */
@Module
public abstract class ManaggerModuel {
    @Binds
    abstract ManaggerContract.Model bindManaggerModel(ManaggerModel model);
}
