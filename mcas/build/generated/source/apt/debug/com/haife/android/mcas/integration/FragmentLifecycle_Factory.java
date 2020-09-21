package com.haife.android.mcas.integration;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class FragmentLifecycle_Factory implements Factory<FragmentLifecycle> {
  private static final FragmentLifecycle_Factory INSTANCE = new FragmentLifecycle_Factory();

  @Override
  public FragmentLifecycle get() {
    return provideInstance();
  }

  public static FragmentLifecycle provideInstance() {
    return new FragmentLifecycle();
  }

  public static FragmentLifecycle_Factory create() {
    return INSTANCE;
  }

  public static FragmentLifecycle newFragmentLifecycle() {
    return new FragmentLifecycle();
  }
}
