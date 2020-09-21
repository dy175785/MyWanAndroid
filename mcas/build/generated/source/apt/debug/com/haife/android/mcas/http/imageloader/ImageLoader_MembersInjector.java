package com.haife.android.mcas.http.imageloader;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ImageLoader_MembersInjector implements MembersInjector<ImageLoader> {
  private final Provider<BaseImageLoaderStrategy> mStrategyProvider;

  public ImageLoader_MembersInjector(Provider<BaseImageLoaderStrategy> mStrategyProvider) {
    this.mStrategyProvider = mStrategyProvider;
  }

  public static MembersInjector<ImageLoader> create(
      Provider<BaseImageLoaderStrategy> mStrategyProvider) {
    return new ImageLoader_MembersInjector(mStrategyProvider);
  }

  @Override
  public void injectMembers(ImageLoader instance) {
    injectMStrategy(instance, mStrategyProvider.get());
  }

  public static void injectMStrategy(ImageLoader instance, BaseImageLoaderStrategy mStrategy) {
    instance.mStrategy = mStrategy;
  }
}
