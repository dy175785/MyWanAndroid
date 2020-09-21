package com.haife.android.mcas.integration;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.haife.android.mcas.integration.cache.Cache;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityLifecycle_Factory implements Factory<ActivityLifecycle> {
  private final Provider<AppManager> mAppManagerProvider;

  private final Provider<Application> mApplicationProvider;

  private final Provider<Cache<String, Object>> mExtrasProvider;

  private final Provider<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycleProvider;

  private final Provider<List<FragmentManager.FragmentLifecycleCallbacks>>
      mFragmentLifecyclesProvider;

  public ActivityLifecycle_Factory(
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

  @Override
  public ActivityLifecycle get() {
    return provideInstance(
        mAppManagerProvider,
        mApplicationProvider,
        mExtrasProvider,
        mFragmentLifecycleProvider,
        mFragmentLifecyclesProvider);
  }

  public static ActivityLifecycle provideInstance(
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache<String, Object>> mExtrasProvider,
      Provider<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycleProvider,
      Provider<List<FragmentManager.FragmentLifecycleCallbacks>> mFragmentLifecyclesProvider) {
    ActivityLifecycle instance = new ActivityLifecycle();
    ActivityLifecycle_MembersInjector.injectMAppManager(instance, mAppManagerProvider.get());
    ActivityLifecycle_MembersInjector.injectMApplication(instance, mApplicationProvider.get());
    ActivityLifecycle_MembersInjector.injectMExtras(instance, mExtrasProvider.get());
    ActivityLifecycle_MembersInjector.injectMFragmentLifecycle(
        instance, DoubleCheck.lazy(mFragmentLifecycleProvider));
    ActivityLifecycle_MembersInjector.injectMFragmentLifecycles(
        instance, DoubleCheck.lazy(mFragmentLifecyclesProvider));
    return instance;
  }

  public static ActivityLifecycle_Factory create(
      Provider<AppManager> mAppManagerProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache<String, Object>> mExtrasProvider,
      Provider<FragmentManager.FragmentLifecycleCallbacks> mFragmentLifecycleProvider,
      Provider<List<FragmentManager.FragmentLifecycleCallbacks>> mFragmentLifecyclesProvider) {
    return new ActivityLifecycle_Factory(
        mAppManagerProvider,
        mApplicationProvider,
        mExtrasProvider,
        mFragmentLifecycleProvider,
        mFragmentLifecyclesProvider);
  }

  public static ActivityLifecycle newActivityLifecycle() {
    return new ActivityLifecycle();
  }
}
