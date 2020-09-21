package com.haife.android.mcas.base;

import com.haife.android.mcas.mvp.IPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseFragment_MembersInjector<P extends IPresenter>
    implements MembersInjector<BaseFragment<P>> {
  private final Provider<P> mPresenterProvider;

  public BaseFragment_MembersInjector(Provider<P> mPresenterProvider) {
    this.mPresenterProvider = mPresenterProvider;
  }

  public static <P extends IPresenter> MembersInjector<BaseFragment<P>> create(
      Provider<P> mPresenterProvider) {
    return new BaseFragment_MembersInjector<P>(mPresenterProvider);
  }

  @Override
  public void injectMembers(BaseFragment<P> instance) {
    injectMPresenter(instance, mPresenterProvider.get());
  }

  public static <P extends IPresenter> void injectMPresenter(
      BaseFragment<P> instance, P mPresenter) {
    instance.mPresenter = mPresenter;
  }
}
