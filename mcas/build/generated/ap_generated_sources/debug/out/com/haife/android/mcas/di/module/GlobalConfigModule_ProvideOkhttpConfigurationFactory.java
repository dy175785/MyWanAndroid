package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideOkhttpConfigurationFactory
    implements Factory<ClientModule.OkhttpConfiguration> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideOkhttpConfigurationFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public ClientModule.OkhttpConfiguration get() {
    return provideInstance(module);
  }

  @Nullable
  public static ClientModule.OkhttpConfiguration provideInstance(GlobalConfigModule module) {
    return proxyProvideOkhttpConfiguration(module);
  }

  public static GlobalConfigModule_ProvideOkhttpConfigurationFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideOkhttpConfigurationFactory(module);
  }

  @Nullable
  public static ClientModule.OkhttpConfiguration proxyProvideOkhttpConfiguration(
      GlobalConfigModule instance) {
    return instance.provideOkhttpConfiguration();
  }
}
