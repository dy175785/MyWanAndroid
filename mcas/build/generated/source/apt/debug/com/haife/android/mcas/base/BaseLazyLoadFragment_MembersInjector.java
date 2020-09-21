package com.haife.android.mcas.base;

import com.haife.android.mcas.mvp.IPresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BaseLazyLoadFragment_MembersInjector<P extends IPresenter>
    implements MembersInjector<BaseLazyLoadFragment<P>> {
  private final Provider<P> mPresenterProvider;

  private final Provider<Unused> mUnusedProvider;

  public BaseLazyLoadFragment_MembersInjector(
      Provider<P> mPresenterProvider, Provider<Unused> mUnusedProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.mUnusedProvider = mUnusedProvider;
  }

  public static <P extends IPresenter> MembersInjector<BaseLazyLoadFragment<P>> create(
      Provider<P> mPresenterProvider, Provider<Unused> mUnusedProvider) {
    return new BaseLazyLoadFragment_MembersInjector<P>(mPresenterProvider, mUnusedProvider);
  }

  @Override
  public void injectMembers(BaseLazyLoadFragment<P> instance) {
    BaseFragment_MembersInjector.injectMPresenter(instance, mPresenterProvider.get());
    injectMUnused(instance, mUnusedProvider.get());
  }

  public static <P extends IPresenter> void injectMUnused(
      BaseLazyLoadFragment<P> instance, Unused mUnused) {
    instance.mUnused = mUnused;
  }
}
