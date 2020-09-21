package com.haife.android.mcas.di.module;

import android.app.Application;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final Provider<Application> applicationProvider;

  private final Provider<ClientModule.RetrofitConfiguration> configurationProvider;

  private final Provider<Retrofit.Builder> builderProvider;

  private final Provider<OkHttpClient> clientProvider;

  private final Provider<HttpUrl> httpUrlProvider;

  private final Provider<Gson> gsonProvider;

  public ClientModule_ProvideRetrofitFactory(
      Provider<Application> applicationProvider,
      Provider<ClientModule.RetrofitConfiguration> configurationProvider,
      Provider<Retrofit.Builder> builderProvider,
      Provider<OkHttpClient> clientProvider,
      Provider<HttpUrl> httpUrlProvider,
      Provider<Gson> gsonProvider) {
    this.applicationProvider = applicationProvider;
    this.configurationProvider = configurationProvider;
    this.builderProvider = builderProvider;
    this.clientProvider = clientProvider;
    this.httpUrlProvider = httpUrlProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return provideInstance(
        applicationProvider,
        configurationProvider,
        builderProvider,
        clientProvider,
        httpUrlProvider,
        gsonProvider);
  }

  public static Retrofit provideInstance(
      Provider<Application> applicationProvider,
      Provider<ClientModule.RetrofitConfiguration> configurationProvider,
      Provider<Retrofit.Builder> builderProvider,
      Provider<OkHttpClient> clientProvider,
      Provider<HttpUrl> httpUrlProvider,
      Provider<Gson> gsonProvider) {
    return proxyProvideRetrofit(
        applicationProvider.get(),
        configurationProvider.get(),
        builderProvider.get(),
        clientProvider.get(),
        httpUrlProvider.get(),
        gsonProvider.get());
  }

  public static ClientModule_ProvideRetrofitFactory create(
      Provider<Application> applicationProvider,
      Provider<ClientModule.RetrofitConfiguration> configurationProvider,
      Provider<Retrofit.Builder> builderProvider,
      Provider<OkHttpClient> clientProvider,
      Provider<HttpUrl> httpUrlProvider,
      Provider<Gson> gsonProvider) {
    return new ClientModule_ProvideRetrofitFactory(
        applicationProvider,
        configurationProvider,
        builderProvider,
        clientProvider,
        httpUrlProvider,
        gsonProvider);
  }

  public static Retrofit proxyProvideRetrofit(
      Application application,
      ClientModule.RetrofitConfiguration configuration,
      Retrofit.Builder builder,
      OkHttpClient client,
      HttpUrl httpUrl,
      Gson gson) {
    return Preconditions.checkNotNull(
        ClientModule.provideRetrofit(application, configuration, builder, client, httpUrl, gson),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
