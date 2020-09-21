package com.haife.android.mcas.base.delegate;

import android.app.Application;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppDelegate_MembersInjector implements MembersInjector<AppDelegate> {
  private final Provider<Application.ActivityLifecycleCallbacks> mActivityLifecycleProvider;

  private final Provider<Application.ActivityLifecycleCallbacks>
      mActivityLifecycleForRxLifecycleProvider;

  public AppDelegate_MembersInjector(
      Provider<Application.ActivityLifecycleCallbacks> mActivityLifecycleProvider,
      Provider<Application.ActivityLifecycleCallbacks> mActivityLifecycleForRxLifecycleProvider) {
    this.mActivityLifecycleProvider = mActivityLifecycleProvider;
    this.mActivityLifecycleForRxLifecycleProvider = mActivityLifecycleForRxLifecycleProvider;
  }

  public static MembersInjector<AppDelegate> create(
      Provider<Application.ActivityLifecycleCallbacks> mActivityLifecycleProvider,
      Provider<Application.ActivityLifecycleCallbacks> mActivityLifecycleForRxLifecycleProvider) {
    return new AppDelegate_MembersInjector(
        mActivityLifecycleProvider, mActivityLifecycleForRxLifecycleProvider);
  }

  @Override
  public void injectMembers(AppDelegate instance) {
    injectMActivityLifecycle(instance, mActivityLifecycleProvider.get());
    injectMActivityLifecycleForRxLifecycle(
        instance, mActivityLifecycleForRxLifecycleProvider.get());
  }

  public static void injectMActivityLifecycle(
      AppDelegate instance, Application.ActivityLifecycleCallbacks mActivityLifecycle) {
    instance.mActivityLifecycle = mActivityLifecycle;
  }

  public static void injectMActivityLifecycleForRxLifecycle(
      AppDelegate instance,
      Application.ActivityLifecycleCallbacks mActivityLifecycleForRxLifecycle) {
    instance.mActivityLifecycleForRxLifecycle = mActivityLifecycleForRxLifecycle;
  }
}
