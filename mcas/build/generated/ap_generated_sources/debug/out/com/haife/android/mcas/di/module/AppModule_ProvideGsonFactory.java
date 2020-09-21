package com.haife.android.mcas.di.module;

import android.app.Application;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideGsonFactory implements Factory<Gson> {
  private final Provider<Application> applicationProvider;

  private final Provider<AppModule.GsonConfiguration> configurationProvider;

  public AppModule_ProvideGsonFactory(
      Provider<Application> applicationProvider,
      Provider<AppModule.GsonConfiguration> configurationProvider) {
    this.applicationProvider = applicationProvider;
    this.configurationProvider = configurationProvider;
  }

  @Override
  public Gson get() {
    return provideInstance(applicationProvider, configurationProvider);
  }

  public static Gson provideInstance(
      Provider<Application> applicationProvider,
      Provider<AppModule.GsonConfiguration> configurationProvider) {
    return proxyProvideGson(applicationProvider.get(), configurationProvider.get());
  }

  public static AppModule_ProvideGsonFactory create(
      Provider<Application> applicationProvider,
      Provider<AppModule.GsonConfiguration> configurationProvider) {
    return new AppModule_ProvideGsonFactory(applicationProvider, configurationProvider);
  }

  public static Gson proxyProvideGson(
      Application application, AppModule.GsonConfiguration configuration) {
    return Preconditions.checkNotNull(
        AppModule.provideGson(application, configuration),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
