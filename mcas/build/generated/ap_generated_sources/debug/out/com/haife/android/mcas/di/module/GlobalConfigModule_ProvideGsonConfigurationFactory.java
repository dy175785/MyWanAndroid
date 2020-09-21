package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideGsonConfigurationFactory
    implements Factory<AppModule.GsonConfiguration> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideGsonConfigurationFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public AppModule.GsonConfiguration get() {
    return provideInstance(module);
  }

  @Nullable
  public static AppModule.GsonConfiguration provideInstance(GlobalConfigModule module) {
    return proxyProvideGsonConfiguration(module);
  }

  public static GlobalConfigModule_ProvideGsonConfigurationFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideGsonConfigurationFactory(module);
  }

  @Nullable
  public static AppModule.GsonConfiguration proxyProvideGsonConfiguration(
      GlobalConfigModule instance) {
    return instance.provideGsonConfiguration();
  }
}
