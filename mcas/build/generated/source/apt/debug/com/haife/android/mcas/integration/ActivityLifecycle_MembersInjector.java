package com.haife.android.mcas.integration;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.haife.android.mcas.integration.cache.Cache;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityLifecycle_MembersInjector implements MembersInjector<ActivityLifecycle> {
  private final Provider<AppManager> mAppManagerProvider;

  private final Provider<Application> mApplicationProvider;

  private final Provider<Cache<String, Object>> mExtrasProvider;

  private final Provider<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycleProvider;

  private final Provider<List<FragmentManager.FragmentLifecycleCallbacks>>
      mFragmentLifecyclesProvider;

  public ActivityLifecycle_MembersInjector(
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache<String, Object>> mExtrasProvider,
      Provider<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycleProvider,
      Provider<List<FragmentManager.FragmentLifecycleCallbacks>> mFragmentLifecyclesProvider) {
    this.mAppManagerProvider = mAppManagerProvider;
    this.mApplicationProvider = mApplicationProvider;
    this.mExtrasProvider = mExtrasProvider;
    this.mFragmentLifecycleProvider = mFragmentLifecycleProvider;
    this.mFragmentLifecyclesProvider = mFragmentLifecyclesProvider;
  }

  public static MembersInjector<ActivityLifecycle> create(
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache<String, Object>> mExtrasProvider,
      Provider<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycleProvider,
      Provider<List<FragmentManager.FragmentLifecycleCallbacks>> mFragmentLifecyclesProvider) {
    return new ActivityLifecycle_MembersInjector(
        mAppManagerProvider,
        mApplicationProvider,
        mExtrasProvider,
        mFragmentLifecycleProvider,
        mFragmentLifecyclesProvider);
  }

  @Override
  public void injectMembers(ActivityLifecycle instance) {
    injectMAppManager(instance, mAppManagerProvider.get());
    injectMApplication(instance, mApplicationProvider.get());
    injectMExtras(instance, mExtrasProvider.get());
    injectMFragmentLifecycle(instance, DoubleCheck.lazy(mFragmentLifecycleProvider));
    injectMFragmentLifecycles(instance, DoubleCheck.lazy(mFragmentLifecyclesProvider));
  }

  public static void injectMAppManager(ActivityLifecycle instance, AppManager mAppManager) {
    instance.mAppManager = mAppManager;
  }

  public static void injectMApplication(ActivityLifecycle instance, Application mApplication) {
    instance.mApplication = mApplication;
  }

  public static void injectMExtras(ActivityLifecycle instance, Cache<String, Object> mExtras) {
    instance.mExtras = mExtras;
  }

  public static void injectMFragmentLifecycle(
      ActivityLifecycle instance,
      Lazy<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycle) {
    instance.mFragmentLifecycle = mFragmentLifecycle;
  }

  public static void injectMFragmentLifecycles(
      ActivityLifecycle instance,
      Lazy<List<FragmentManager.FragmentLifecycleCallbacks>> mFragmentLifecycles) {
    instance.mFragmentLifecycles = mFragmentLifecycles;
  }
}
