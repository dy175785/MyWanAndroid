package com.haife.android.mcas.integration;

import android.app.Application;
import com.haife.android.mcas.integration.cache.Cache;
import dagger.Lazy;
import dagger.MembersInjector;
import dagger.internal.DoubleCheck;
import io.rx_cache2.internal.RxCache;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RepositoryManager_MembersInjector implements MembersInjector<RepositoryManager> {
  private final Provider<Retrofit> mRetrofitProvider;

  private final Provider<RxCache> mRxCacheProvider;

  private final Provider<Application> mApplicationProvider;

  private final Provider<Cache.Factory> mCacheFactoryProvider;

  private final Provider<IRepositoryManager.ObtainServiceDelegate> mObtainServiceDelegateProvider;

  public RepositoryManager_MembersInjector(
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

  public static MembersInjector<RepositoryManager> create(
      Provider<Retrofit> mRetrofitProvider,
      Provider<RxCache> mRxCacheProvider,
      Provider<Application> mApplicationProvider,
      Provider<Cache.Factory> mCacheFactoryProvider,
      Provider<IRepositoryManager.ObtainServiceDelegate> mObtainServiceDelegateProvider) {
    return new RepositoryManager_MembersInjector(
        mRetrofitProvider,
        mRxCacheProvider,
        mApplicationProvider,
        mCacheFactoryProvider,
        mObtainServiceDelegateProvider);
  }

  @Override
  public void injectMembers(RepositoryManager instance) {
    injectMRetrofit(instance, DoubleCheck.lazy(mRetrofitProvider));
    injectMRxCache(instance, DoubleCheck.lazy(mRxCacheProvider));
    injectMApplication(instance, mApplicationProvider.get());
    injectMCacheFactory(instance, mCacheFactoryProvider.get());
    injectMObtainServiceDelegate(instance, mObtainServiceDelegateProvider.get());
  }

  public static void injectMRetrofit(RepositoryManager instance, Lazy<Retrofit> mRetrofit) {
    instance.mRetrofit = mRetrofit;
  }

  public static void injectMRxCache(RepositoryManager instance, Lazy<RxCache> mRxCache) {
    instance.mRxCache = mRxCache;
  }

  public static void injectMApplication(RepositoryManager instance, Application mApplication) {
    instance.mApplication = mApplication;
  }

  public static void injectMCacheFactory(RepositoryManager instance, Cache.Factory mCacheFactory) {
    instance.mCacheFactory = mCacheFactory;
  }

  public static void injectMObtainServiceDelegate(
      RepositoryManager instance, IRepositoryManager.ObtainServiceDelegate mObtainServiceDelegate) {
    instance.mObtainServiceDelegate = mObtainServiceDelegate;
  }
}
