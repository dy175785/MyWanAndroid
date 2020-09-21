package com.haife.android.mcas.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.concurrent.ExecutorService;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideExecutorServiceFactory
    implements Factory<ExecutorService> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideExecutorServiceFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  public ExecutorService get() {
    return provideInstance(module);
  }

  public static ExecutorService provideInstance(GlobalConfigModule module) {
    return proxyProvideExecutorService(module);
  }

  public static GlobalConfigModule_ProvideExecutorServiceFactory create(GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideExecutorServiceFactory(module);
  }

  public static ExecutorService proxyProvideExecutorService(GlobalConfigModule instance) {
    return Preconditions.checkNotNull(
        instance.provideExecutorService(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
