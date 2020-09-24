package com.dy.mywanandroid.di.component;

import com.dy.mywanandroid.di.moduel.ManaggerModuel;
import com.dy.mywanandroid.mvp.contract.ManaggerContract;
import com.dy.mywanandroid.mvp.ui.fragment.AccountDataFragment;
import com.dy.mywanandroid.mvp.ui.fragment.AccountFragment;
import com.dy.mywanandroid.mvp.ui.fragment.ManaggerFragment;
import com.dy.mywanandroid.mvp.ui.fragment.ProjectDataFragment;
import com.haife.android.mcas.di.component.AppComponent;
import com.haife.android.mcas.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;

@ActivityScope
@Component(modules = ManaggerModuel.class,dependencies = AppComponent.class)
public interface ManaggerComponent {
    void inject(ManaggerFragment fragment);
    void inject(AccountFragment fragment);
    void inject(ProjectDataFragment fragment);
    void inject(AccountDataFragment fragment);
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder view(ManaggerContract.View view);

        Builder appComponent(AppComponent appComponent);

        ManaggerComponent build();
    }
}
