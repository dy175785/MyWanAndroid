package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import com.haife.android.mcas.http.imageloader.BaseImageLoaderStrategy;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideImageLoaderStrategyFactory
    implements Factory<BaseImageLoaderStrategy> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideImageLoaderStrategyFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public BaseImageLoaderStrategy get() {
    return provideInstance(module);
  }

  @Nullable
  public static BaseImageLoaderStrategy provideInstance(GlobalConfigModule module) {
    return proxyProvideImageLoaderStrategy(module);
  }

  public static GlobalConfigModule_ProvideImageLoaderStrategyFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideImageLoaderStrategyFactory(module);
  }

  @Nullable
  public static BaseImageLoaderStrategy proxyProvideImageLoaderStrategy(
      GlobalConfigModule instance) {
    return instance.provideImageLoaderStrategy();
  }
}
