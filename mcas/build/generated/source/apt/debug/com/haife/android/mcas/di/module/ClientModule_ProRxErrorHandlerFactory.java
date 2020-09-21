package com.haife.android.mcas.di.module;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProRxErrorHandlerFactory implements Factory<RxErrorHandler> {
  private final Provider<Application> applicationProvider;

  private final Provider<ResponseErrorListener> listenerProvider;

  public ClientModule_ProRxErrorHandlerFactory(
      Provider<Application> applicationProvider, Provider<ResponseErrorListener> listenerProvider) {
    this.applicationProvider = applicationProvider;
    this.listenerProvider = listenerProvider;
  }

  @Override
  public RxErrorHandler get() {
    return provideInstance(applicationProvider, listenerProvider);
  }

  public static RxErrorHandler provideInstance(
      Provider<Application> applicationProvider, Provider<ResponseErrorListener> listenerProvider) {
    return proxyProRxErrorHandler(applicationProvider.get(), listenerProvider.get());
  }

  public static ClientModule_ProRxErrorHandlerFactory create(
      Provider<Application> applicationProvider, Provider<ResponseErrorListener> listenerProvider) {
    return new ClientModule_ProRxErrorHandlerFactory(applicationProvider, listenerProvider);
  }

  public static RxErrorHandler proxyProRxErrorHandler(
      Application application, ResponseErrorListener listener) {
    return Preconditions.checkNotNull(
        ClientModule.proRxErrorHandler(application, listener),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
