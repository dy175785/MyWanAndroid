package com.haife.android.mcas.di.module;

import android.app.Application;
import com.haife.android.mcas.http.GlobalHttpHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideClientFactory implements Factory<OkHttpClient> {
  private final Provider<Application> applicationProvider;

  private final Provider<ClientModule.OkhttpConfiguration> configurationProvider;

  private final Provider<OkHttpClient.Builder> builderProvider;

  private final Provider<Interceptor> interceptProvider;

  private final Provider<List<Interceptor>> interceptorsProvider;

  private final Provider<GlobalHttpHandler> handlerProvider;

  private final Provider<ExecutorService> executorServiceProvider;

  public ClientModule_ProvideClientFactory(
      Provider<Application> applicationProvider,
      Provider<ClientModule.OkhttpConfiguration> configurationProvider,
      Provider<OkHttpClient.Builder> builderProvider,
      Provider<Interceptor> interceptProvider,
      Provider<List<Interceptor>> interceptorsProvider,
      Provider<GlobalHttpHandler> handlerProvider,
      Provider<ExecutorService> executorServiceProvider) {
    this.applicationProvider = applicationProvider;
    this.configurationProvider = configurationProvider;
    this.builderProvider = builderProvider;
    this.interceptProvider = interceptProvider;
    this.interceptorsProvider = interceptorsProvider;
    this.handlerProvider = handlerProvider;
    this.executorServiceProvider = executorServiceProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideInstance(
        applicationProvider,
        configurationProvider,
        builderProvider,
        interceptProvider,
        interceptorsProvider,
        handlerProvider,
        executorServiceProvider);
  }

  public static OkHttpClient provideInstance(
      Provider<Application> applicationProvider,
      Provider<ClientModule.OkhttpConfiguration> configurationProvider,
      Provider<OkHttpClient.Builder> builderProvider,
      Provider<Interceptor> interceptProvider,
      Provider<List<Interceptor>> interceptorsProvider,
      Provider<GlobalHttpHandler> handlerProvider,
      Provider<ExecutorService> executorServiceProvider) {
    return proxyProvideClient(
        applicationProvider.get(),
        configurationProvider.get(),
        builderProvider.get(),
        interceptProvider.get(),
        interceptorsProvider.get(),
        handlerProvider.get(),
        executorServiceProvider.get());
  }

  public static ClientModule_ProvideClientFactory create(
      Provider<Application> applicationProvider,
      Provider<ClientModule.OkhttpConfiguration> configurationProvider,
      Provider<OkHttpClient.Builder> builderProvider,
      Provider<Interceptor> interceptProvider,
      Provider<List<Interceptor>> interceptorsProvider,
      Provider<GlobalHttpHandler> handlerProvider,
      Provider<ExecutorService> executorServiceProvider) {
    return new ClientModule_ProvideClientFactory(
        applicationProvider,
        configurationProvider,
        builderProvider,
        interceptProvider,
        interceptorsProvider,
        handlerProvider,
        executorServiceProvider);
  }

  public static OkHttpClient proxyProvideClient(
      Application application,
      ClientModule.OkhttpConfiguration configuration,
      OkHttpClient.Builder builder,
      Interceptor intercept,
      List<Interceptor> interceptors,
      GlobalHttpHandler handler,
      ExecutorService executorService) {
    return Preconditions.checkNotNull(
        ClientModule.provideClient(
            application, configuration, builder, intercept, interceptors, handler, executorService),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
