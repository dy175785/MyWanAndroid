package com.haife.android.mcas.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideResponseErrorListenerFactory
    implements Factory<ResponseErrorListener> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideResponseErrorListenerFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  public ResponseErrorListener get() {
    return provideInstance(module);
  }

  public static ResponseErrorListener provideInstance(GlobalConfigModule module) {
    return proxyProvideResponseErrorListener(module);
  }

  public static GlobalConfigModule_ProvideResponseErrorListenerFactory create(
      GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideResponseErrorListenerFactory(module);
  }

  public static ResponseErrorListener proxyProvideResponseErrorListener(
      GlobalConfigModule instance) {
    return Preconditions.checkNotNull(
        instance.provideResponseErrorListener(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
