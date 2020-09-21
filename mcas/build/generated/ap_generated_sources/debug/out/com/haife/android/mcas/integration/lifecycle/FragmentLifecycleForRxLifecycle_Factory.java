package com.haife.android.mcas.integration.lifecycle;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentLifecycleForRxLifecycle_Factory
    implements Factory<FragmentLifecycleForRxLifecycle> {
  private static final FragmentLifecycleForRxLifecycle_Factory INSTANCE =
      new FragmentLifecycleForRxLifecycle_Factory();

  @Override
  public FragmentLifecycleForRxLifecycle get() {
    return provideInstance();
  }

  public static FragmentLifecycleForRxLifecycle provideInstance() {
    return new FragmentLifecycleForRxLifecycle();
  }

  public static FragmentLifecycleForRxLifecycle_Factory create() {
    return INSTANCE;
  }

  public static FragmentLifecycleForRxLifecycle newFragmentLifecycleForRxLifecycle() {
    return new FragmentLifecycleForRxLifecycle();
  }
}
