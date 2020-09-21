package com.haife.android.mcas.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideRetrofitBuilderFactory implements Factory<Retrofit.Builder> {
  private static final ClientModule_ProvideRetrofitBuilderFactory INSTANCE =
      new ClientModule_ProvideRetrofitBuilderFactory();

  @Override
  public Retrofit.Builder get() {
    return provideInstance();
  }

  public static Retrofit.Builder provideInstance() {
    return proxyProvideRetrofitBuilder();
  }

  public static ClientModule_ProvideRetrofitBuilderFactory create() {
    return INSTANCE;
  }

  public static Retrofit.Builder proxyProvideRetrofitBuilder() {
    return Preconditions.checkNotNull(
        ClientModule.provideRetrofitBuilder(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
