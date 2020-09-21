package com.haife.android.mcas.http.imageloader;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ImageLoader_Factory implements Factory<ImageLoader> {
  private final Provider<BaseImageLoaderStrategy> mStrategyProvider;

  public ImageLoader_Factory(Provider<BaseImageLoaderStrategy> mStrategyProvider) {
    this.mStrategyProvider = mStrategyProvider;
  }

  @Override
  public ImageLoader get() {
    return provideInstance(mStrategyProvider);
  }

  public static ImageLoader provideInstance(Provider<BaseImageLoaderStrategy> mStrategyProvider) {
    ImageLoader instance = new ImageLoader();
    ImageLoader_MembersInjector.injectMStrategy(instance, mStrategyProvider.get());
    return instance;
  }

  public static ImageLoader_Factory create(Provider<BaseImageLoaderStrategy> mStrategyProvider) {
    return new ImageLoader_Factory(mStrategyProvider);
  }

  public static ImageLoader newImageLoader() {
    return new ImageLoader();
  }
}
