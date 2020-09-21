package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideRetrofitConfigurationFactory
    implements Factory<ClientModule.RetrofitConfiguration> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideRetrofitConfigurationFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public ClientModule.RetrofitConfiguration get() {
    return provideInstance(module);
  }

  @Nullable
  public static ClientModule.RetrofitConfiguration provideInstance(GlobalConfigModule module) {
    return proxyProvideRetrofitConfiguration(module);
  }

  public static GlobalConfigModule_ProvideRetrofitConfigurationFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideRetrofitConfigurationFactory(module);
  }

  @Nullable
  public static ClientModule.RetrofitConfiguration proxyProvideRetrofitConfiguration(
      GlobalConfigModule instance) {
    return instance.provideRetrofitConfiguration();
  }
}
