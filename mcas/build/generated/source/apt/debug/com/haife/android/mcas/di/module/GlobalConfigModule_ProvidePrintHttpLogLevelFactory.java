package com.haife.android.mcas.di.module;

import com.haife.android.mcas.http.log.RequestInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvidePrintHttpLogLevelFactory
    implements Factory<RequestInterceptor.Level> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvidePrintHttpLogLevelFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  public RequestInterceptor.Level get() {
    return provideInstance(module);
  }

  public static RequestInterceptor.Level provideInstance(GlobalConfigModule module) {
    return proxyProvidePrintHttpLogLevel(module);
  }

  public static GlobalConfigModule_ProvidePrintHttpLogLevelFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvidePrintHttpLogLevelFactory(module);
  }

  public static RequestInterceptor.Level proxyProvidePrintHttpLogLevel(
      GlobalConfigModule instance) {
    return Preconditions.checkNotNull(
        instance.providePrintHttpLogLevel(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
