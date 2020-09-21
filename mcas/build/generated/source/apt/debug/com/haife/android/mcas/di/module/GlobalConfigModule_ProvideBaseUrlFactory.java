package com.haife.android.mcas.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.HttpUrl;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideBaseUrlFactory implements Factory<HttpUrl> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideBaseUrlFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  public HttpUrl get() {
    return provideInstance(module);
  }

  public static HttpUrl provideInstance(GlobalConfigModule module) {
    return proxyProvideBaseUrl(module);
  }

  public static GlobalConfigModule_ProvideBaseUrlFactory create(GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideBaseUrlFactory(module);
  }

  public static HttpUrl proxyProvideBaseUrl(GlobalConfigModule instance) {
    return Preconditions.checkNotNull(
        instance.provideBaseUrl(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
