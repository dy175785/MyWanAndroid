package com.dy.mywanandroid.di.component;

import com.dy.mywanandroid.di.moduel.MainModuel;
import com.dy.mywanandroid.mvp.contract.MianContract;
import com.dy.mywanandroid.mvp.model.MainModel;
import com.dy.mywanandroid.mvp.ui.fragment.LoginFragment;
import com.dy.mywanandroid.mvp.ui.fragment.MainFragment;
import com.dy.mywanandroid.mvp.ui.fragment.RegisterFragment;
import com.haife.android.mcas.di.component.AppComponent;
import com.haife.android.mcas.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Administrator
 *
 * @author dy
 * created at 2020/9/21 0021 15:45
 */
@ActivityScope
@Component(modules = MainModuel.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainFragment mainFragment);
    void inject(LoginFragment fragment);
    void inject(RegisterFragment fragment);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder view(MianContract.View view);

        Builder appComponent(AppComponent appComponent);

        MainComponent build();
    }
}
