package com.haife.android.mcas.base;

import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class Unused_Factory implements Factory<Unused> {
  private static final Unused_Factory INSTANCE = new Unused_Factory();

  @Override
  public Unused get() {
    return provideInstance();
  }

  public static Unused provideInstance() {
    return new Unused();
  }

  public static Unused_Factory create() {
    return INSTANCE;
  }

  public static Unused newUnused() {
    return new Unused();
  }
}
