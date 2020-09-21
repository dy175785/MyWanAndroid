package com.haife.android.mcas.di.module;

import android.app.Application;
import com.haife.android.mcas.integration.cache.Cache;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideCacheFactoryFactory implements Factory<Cache.Factory> {
  private final GlobalConfigModule module;

  private final Provider<Application> applicationProvider;

  public GlobalConfigModule_ProvideCacheFactoryFactory(
      GlobalConfigModule module, Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Cache.Factory get() {
    return provideInstance(module, applicationProvider);
  }

  public static Cache.Factory provideInstance(
      GlobalConfigModule module, Provider<Application> applicationProvider) {
    return proxyProvideCacheFactory(module, applicationProvider.get());
  }

  public static GlobalConfigModule_ProvideCacheFactoryFactory create(
      GlobalConfigModule module, Provider<Application> applicationProvider) {
    return new GlobalConfigModule_ProvideCacheFactoryFactory(module, applicationProvider);
  }

  public static Cache.Factory proxyProvideCacheFactory(
      GlobalConfigModule instance, Application application) {
    return Preconditions.checkNotNull(
        instance.provideCacheFactory(application),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
