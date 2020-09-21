package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import dagger.internal.Factory;
import java.util.List;
import javax.annotation.Generated;
import okhttp3.Interceptor;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideInterceptorsFactory
    implements Factory<List<Interceptor>> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideInterceptorsFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public List<Interceptor> get() {
    return provideInstance(module);
  }

  @Nullable
  public static List<Interceptor> provideInstance(GlobalConfigModule module) {
    return proxyProvideInterceptors(module);
  }

  public static GlobalConfigModule_ProvideInterceptorsFactory create(GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideInterceptorsFactory(module);
  }

  @Nullable
  public static List<Interceptor> proxyProvideInterceptors(GlobalConfigModule instance) {
    return instance.provideInterceptors();
  }
}
