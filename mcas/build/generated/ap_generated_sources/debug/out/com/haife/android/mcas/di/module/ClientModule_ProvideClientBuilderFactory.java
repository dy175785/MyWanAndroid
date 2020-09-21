package com.haife.android.mcas.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideClientBuilderFactory
    implements Factory<OkHttpClient.Builder> {
  private static final ClientModule_ProvideClientBuilderFactory INSTANCE =
      new ClientModule_ProvideClientBuilderFactory();

  @Override
  public OkHttpClient.Builder get() {
    return provideInstance();
  }

  public static OkHttpClient.Builder provideInstance() {
    return proxyProvideClientBuilder();
  }

  public static ClientModule_ProvideClientBuilderFactory create() {
    return INSTANCE;
  }

  public static OkHttpClient.Builder proxyProvideClientBuilder() {
    return Preconditions.checkNotNull(
        ClientModule.provideClientBuilder(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
