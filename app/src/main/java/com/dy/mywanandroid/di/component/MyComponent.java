package com.dy.mywanandroid.di.component;

import com.dy.mywanandroid.di.moduel.MyModuel;
import com.dy.mywanandroid.mvp.contract.MyContract;
import com.dy.mywanandroid.mvp.ui.activity.RankingActivity;
import com.dy.mywanandroid.mvp.ui.fragment.MyFragment;
import com.haife.android.mcas.di.component.AppComponent;
import com.haife.android.mcas.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;

@ActivityScope
@Component(modules = MyModuel.class,dependencies = AppComponent.class)
public interface MyComponent {
    void inject(MyFragment fragment);
    void inject(RankingActivity activity);
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder view(MyContract.View view);

        Builder appComponent(AppComponent appComponent);

        MyComponent build();
    }
}
