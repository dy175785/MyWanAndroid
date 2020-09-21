package com.haife.android.mcas.integration;

import android.app.Application;
import com.haife.android.mcas.integration.cache.Cache;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import io.rx_cache2.internal.RxCache;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RepositoryManager_Factory implements Factory<RepositoryManager> {
  private final Provider<Retrofit> mRetrofitProvider;

  private final Provider<RxCache> mRxCacheProvider;

  private final Provider<Application> mApplicationProvider;

  private final Provider<Cache.Factory> mCacheFactoryProvider;

  private final Provider<IRepositoryManager.ObtainServiceDelegate> mObtainServiceDelegateProvider;

  public RepositoryManager_Factory(
      Provider<Retrofit> mRetrofitProvider,
      Provider<RxCache> mRxCacheProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache.Factory> mCacheFactoryProvider,
      Provider<IRepositoryManager.ObtainServiceDelegate> mObtainServiceDelegateProvider) {
    this.mRetrofitProvider = mRetrofitProvider;
    this.mRxCacheProvider = mRxCacheProvider;
    this.mApplicationProvider = mApplicationProvider;
    this.mCacheFactoryProvider = mCacheFactoryProvider;
    this.mObtainServiceDelegateProvider = mObtainServiceDelegateProvider;
  }

  @Override
  public RepositoryManager get() {
    return provideInstance(
        mRetrofitProvider,
        mRxCacheProvider,
        mApplicationProvider,
        mCacheFactoryProvider,
        mObtainServiceDelegateProvider);
  }

  public static RepositoryManager provideInstance(
      Provider<Retrofit> mRetrofitProvider,
      Provider<RxCache> mRxCacheProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache.Factory> mCacheFactoryProvider,
      Provider<IRepositoryManager.ObtainServiceDelegate> mObtainServiceDelegateProvider) {
    RepositoryManager instance = new RepositoryManager();
    RepositoryManager_MembersInjector.injectMRetrofit(
        instance, DoubleCheck.lazy(mRetrofitProvider));
    RepositoryManager_MembersInjector.injectMRxCache(instance, DoubleCheck.lazy(mRxCacheProvider));
    RepositoryManager_MembersInjector.injectMApplication(instance, mApplicationProvider.get());
    RepositoryManager_MembersInjector.injectMCacheFactory(instance, mCacheFactoryProvider.get());
    RepositoryManager_MembersInjector.injectMObtainServiceDelegate(
        instance, mObtainServiceDelegateProvider.get());
    return instance;
  }

  public static RepositoryManager_Factory create(
      Provider<Retrofit> mRetrofitProvider,
      Provider<RxCache> mRxCacheProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache.Factory> mCacheFactoryProvider,
      Provider<IRepositoryManager.ObtainServiceDelegate> mObtainServiceDelegateProvider) {
    return new RepositoryManager_Factory(
        mRetrofitProvider,
        mRxCacheProvider,
        mApplicationProvider,
        mCacheFactoryProvider,
        mObtainServiceDelegateProvider);
  }

  public static RepositoryManager newRepositoryManager() {
    return new RepositoryManager();
  }
}
