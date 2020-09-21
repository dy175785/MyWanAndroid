package com.haife.android.mcas.integration.lifecycle;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityLifecycleForRxLifecycle_Factory
    implements Factory<ActivityLifecycleForRxLifecycle> {
  private final Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider;

  public ActivityLifecycleForRxLifecycle_Factory(
      Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider) {
    this.mFragmentLifecycleProvider = mFragmentLifecycleProvider;
  }

  @Override
  public ActivityLifecycleForRxLifecycle get() {
    return provideInstance(mFragmentLifecycleProvider);
  }

  public static ActivityLifecycleForRxLifecycle provideInstance(
      Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider) {
    ActivityLifecycleForRxLifecycle instance = new ActivityLifecycleForRxLifecycle();
    ActivityLifecycleForRxLifecycle_MembersInjector.injectMFragmentLifecycle(
        instance, DoubleCheck.lazy(mFragmentLifecycleProvider));
    return instance;
  }

  public static ActivityLifecycleForRxLifecycle_Factory create(
      Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider) {
    return new ActivityLifecycleForRxLifecycle_Factory(mFragmentLifecycleProvider);
  }

  public static ActivityLifecycleForRxLifecycle newActivityLifecycleForRxLifecycle() {
    return new ActivityLifecycleForRxLifecycle();
  }
}
