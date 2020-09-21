package com.haife.android.mcas.base;

import com.haife.android.mcas.mvp.IPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseActivity_MembersInjector<P extends IPresenter>
    implements MembersInjector<BaseActivity<P>> {
  private final Provider<P> mPresenterProvider;

  public BaseActivity_MembersInjector(Provider<P> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <P extends IPresenter> MembersInjector<BaseActivity<P>> create(
      Provider<P> mPresenterProvider) {
    return new BaseActivity_MembersInjector<P>(mPresenterProvider);
  }

  @Override
  public void injectMembers(BaseActivity<P> instance) {
    injectMPresenter(instance, mPresenterProvider.get());
  }

  public static <P extends IPresenter> void injectMPresenter(
      BaseActivity<P> instance, P mPresenter) {
    instance.mPresenter = mPresenter;
  }
}
