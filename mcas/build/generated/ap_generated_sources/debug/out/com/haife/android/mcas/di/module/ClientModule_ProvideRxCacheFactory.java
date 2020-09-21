package com.haife.android.mcas.di.module;

import android.app.Application;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.rx_cache2.internal.RxCache;
import java.io.File;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideRxCacheFactory implements Factory<RxCache> {
  private final Provider<Application> applicationProvider;

  private final Provider<ClientModule.RxCacheConfiguration> configurationProvider;

  private final Provider<File> cacheDirectoryProvider;

  private final Provider<Gson> gsonProvider;

  public ClientModule_ProvideRxCacheFactory(
      Provider<Application> applicationProvider,
      Provider<ClientModule.RxCacheConfiguration> configurationProvider,
      Provider<File> cacheDirectoryProvider,
      Provider<Gson> gsonProvider) {
    this.applicationProvider = applicationProvider;
    this.configurationProvider = configurationProvider;
    this.cacheDirectoryProvider = cacheDirectoryProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public RxCache get() {
    return provideInstance(
        applicationProvider, configurationProvider, cacheDirectoryProvider, gsonProvider);
  }

  public static RxCache provideInstance(
      Provider<Application> applicationProvider,
      Provider<ClientModule.RxCacheConfiguration> configurationProvider,
      Provider<File> cacheDirectoryProvider,
      Provider<Gson> gsonProvider) {
    return proxyProvideRxCache(
        applicationProvider.get(),
        configurationProvider.get(),
        cacheDirectoryProvider.get(),
        gsonProvider.get());
  }

  public static ClientModule_ProvideRxCacheFactory create(
      Provider<Application> applicationProvider,
      Provider<ClientModule.RxCacheConfiguration> configurationProvider,
      Provider<File> cacheDirectoryProvider,
      Provider<Gson> gsonProvider) {
    return new ClientModule_ProvideRxCacheFactory(
        applicationProvider, configurationProvider, cacheDirectoryProvider, gsonProvider);
  }

  public static RxCache proxyProvideRxCache(
      Application application,
      ClientModule.RxCacheConfiguration configuration,
      File cacheDirectory,
      Gson gson) {
    return Preconditions.checkNotNull(
        ClientModule.provideRxCache(application, configuration, cacheDirectory, gson),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
