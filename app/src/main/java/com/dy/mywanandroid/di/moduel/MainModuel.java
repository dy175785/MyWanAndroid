package com.dy.mywanandroid.di.moduel;

import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.model.MainModel;

import dagger.Binds;
import dagger.Module;

/**
 *  Administrator
 *  @author dy
 *  created at 2020/9/21 0021 15:44
 */
@Module
public abstract class MainModuel {
    @Binds
    abstract MianContract.Model bindMainModuel(MainModel model);
}
