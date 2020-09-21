package com.haife.android.mcas.di.module;

import androidx.annotation.Nullable;
import com.haife.android.mcas.integration.IRepositoryManager;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideObtainServiceDelegateFactory
    implements Factory<IRepositoryManager.ObtainServiceDelegate> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideObtainServiceDelegateFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  @Nullable
  public IRepositoryManager.ObtainServiceDelegate get() {
    return provideInstance(module);
  }

  @Nullable
  public static IRepositoryManager.ObtainServiceDelegate provideInstance(
      GlobalConfigModule module) {
    return proxyProvideObtainServiceDelegate(module);
  }

  public static GlobalConfigModule_ProvideObtainServiceDelegateFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideObtainServiceDelegateFactory(module);
  }

  @Nullable
  public static IRepositoryManager.ObtainServiceDelegate proxyProvideObtainServiceDelegate(
      GlobalConfigModule instance) {
    return instance.provideObtainServiceDelegate();
  }
}
