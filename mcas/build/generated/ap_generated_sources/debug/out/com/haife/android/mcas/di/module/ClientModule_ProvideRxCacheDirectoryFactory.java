package com.haife.android.mcas.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ClientModule_ProvideRxCacheDirectoryFactory implements Factory<File> {
  private final Provider<File> cacheDirProvider;

  public ClientModule_ProvideRxCacheDirectoryFactory(Provider<File> cacheDirProvider) {
    this.cacheDirProvider = cacheDirProvider;
  }

  @Override
  public File get() {
    return provideInstance(cacheDirProvider);
  }

  public static File provideInstance(Provider<File> cacheDirProvider) {
    return proxyProvideRxCacheDirectory(cacheDirProvider.get());
  }

  public static ClientModule_ProvideRxCacheDirectoryFactory create(
      Provider<File> cacheDirProvider) {
    return new ClientModule_ProvideRxCacheDirectoryFactory(cacheDirProvider);
  }

  public static File proxyProvideRxCacheDirectory(File cacheDir) {
    return Preconditions.checkNotNull(
        ClientModule.provideRxCacheDirectory(cacheDir),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
