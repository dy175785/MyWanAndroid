package com.haife.android.mcas.di.module;

import android.app.Application;
import com.haife.android.mcas.integration.AppManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideAppManagerFactory implements Factory<AppManager> {
  private final Provider<Application> applicationProvider;

  public AppModule_ProvideAppManagerFactory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AppManager get() {
    return provideInstance(applicationProvider);
  }

  public static AppManager provideInstance(Provider<Application> applicationProvider) {
    return proxyProvideAppManager(applicationProvider.get());
  }

  public static AppModule_ProvideAppManagerFactory create(
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideAppManagerFactory(applicationProvider);
  }

  public static AppManager proxyProvideAppManager(Application application) {
    return Preconditions.checkNotNull(
        AppModule.provideAppManager(application),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
