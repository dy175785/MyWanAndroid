package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import com.haife.android.mcas.http.GlobalHttpHandler;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideGlobalHttpHandlerFactory
    implements Factory<GlobalHttpHandler> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideGlobalHttpHandlerFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public GlobalHttpHandler get() {
    return provideInstance(module);
  }

  @Nullable
  public static GlobalHttpHandler provideInstance(GlobalConfigModule module) {
    return proxyProvideGlobalHttpHandler(module);
  }

  public static GlobalConfigModule_ProvideGlobalHttpHandlerFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideGlobalHttpHandlerFactory(module);
  }

  @Nullable
  public static GlobalHttpHandler proxyProvideGlobalHttpHandler(GlobalConfigModule instance) {
    return instance.provideGlobalHttpHandler();
  }
}
