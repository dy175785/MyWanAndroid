package com.haife.android.mcas.di.module;

import com.haife.android.mcas.integration.cache.Cache;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideExtrasFactory implements Factory<Cache<String, Object>> {
  private final Provider<Cache.Factory> cacheFactoryProvider;

  public AppModule_ProvideExtrasFactory(Provider<Cache.Factory> cacheFactoryProvider) {
    this.cacheFactoryProvider = cacheFactoryProvider;
  }

  @Override
  public Cache<String, Object> get() {
    return provideInstance(cacheFactoryProvider);
  }

  public static Cache<String, Object> provideInstance(
      Provider<Cache.Factory> cacheFactoryProvider) {
    return proxyProvideExtras(cacheFactoryProvider.get());
  }

  public static AppModule_ProvideExtrasFactory create(
      Provider<Cache.Factory> cacheFactoryProvider) {
    return new AppModule_ProvideExtrasFactory(cacheFactoryProvider);
  }

  public static Cache<String, Object> proxyProvideExtras(Cache.Factory cacheFactory) {
    return Preconditions.checkNotNull(
        AppModule.provideExtras(cacheFactory),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
