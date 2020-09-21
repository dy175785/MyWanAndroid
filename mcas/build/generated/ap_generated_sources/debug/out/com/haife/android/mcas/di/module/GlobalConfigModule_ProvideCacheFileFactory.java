package com.haife.android.mcas.di.module;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideCacheFileFactory implements Factory<File> {
  private final GlobalConfigModule module;

  private final Provider<Application> applicationProvider;

  public GlobalConfigModule_ProvideCacheFileFactory(
      GlobalConfigModule module, Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public File get() {
    return provideInstance(module, applicationProvider);
  }

  public static File provideInstance(
      GlobalConfigModule module, Provider<Application> applicationProvider) {
    return proxyProvideCacheFile(module, applicationProvider.get());
  }

  public static GlobalConfigModule_ProvideCacheFileFactory create(
      GlobalConfigModule module, Provider<Application> applicationProvider) {
    return new GlobalConfigModule_ProvideCacheFileFactory(module, applicationProvider);
  }

  public static File proxyProvideCacheFile(GlobalConfigModule instance, Application application) {
    return Preconditions.checkNotNull(
        instance.provideCacheFile(application),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
