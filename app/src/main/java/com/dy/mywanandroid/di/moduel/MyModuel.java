package com.dy.mywanandroid.di.moduel;

import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.model.MyModel;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MyModuel {
    @Binds
    abstract MyContract.Model bindMyMoel(MyModel myModel);
}
