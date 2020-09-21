package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideRxCacheConfigurationFactory
    implements Factory<ClientModule.RxCacheConfiguration> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideRxCacheConfigurationFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public ClientModule.RxCacheConfiguration get() {
    return provideInstance(module);
  }

  @Nullable
  public static ClientModule.RxCacheConfiguration provideInstance(GlobalConfigModule module) {
    return proxyProvideRxCacheConfiguration(module);
  }

  public static GlobalConfigModule_ProvideRxCacheConfigurationFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideRxCacheConfigurationFactory(module);
  }

  @Nullable
  public static ClientModule.RxCacheConfiguration proxyProvideRxCacheConfiguration(
      GlobalConfigModule instance) {
    return instance.provideRxCacheConfiguration();
  }
}
