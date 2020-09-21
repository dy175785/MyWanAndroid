package com.haife.android.mcas.integration.lifecycle;

import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ActivityLifecycleForRxLifecycle_MembersInjector
    implements MembersInjector<ActivityLifecycleForRxLifecycle> {
  private final Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider;

  public ActivityLifecycleForRxLifecycle_MembersInjector(
      Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider) {
    this.mFragmentLifecycleProvider = mFragmentLifecycleProvider;
  }

  public static MembersInjector<ActivityLifecycleForRxLifecycle> create(
      Provider<FragmentLifecycleForRxLifecycle> mFragmentLifecycleProvider) {
    return new ActivityLifecycleForRxLifecycle_MembersInjector(mFragmentLifecycleProvider);
  }

  @Override
  public void injectMembers(ActivityLifecycleForRxLifecycle instance) {
    injectMFragmentLifecycle(instance, DoubleCheck.lazy(mFragmentLifecycleProvider));
  }

  public static void injectMFragmentLifecycle(
      ActivityLifecycleForRxLifecycle instance,
      Lazy<FragmentLifecycleForRxLifecycle> mFragmentLifecycle) {
    instance.mFragmentLifecycle = mFragmentLifecycle;
  }
}
