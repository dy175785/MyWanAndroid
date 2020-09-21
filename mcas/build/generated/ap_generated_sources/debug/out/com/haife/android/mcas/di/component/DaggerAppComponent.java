package com.haife.android.mcas.di.component;

import android.app.Application;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.haife.android.mcas.base.delegate.AppDelegate;
import com.haife.android.mcas.base.delegate.AppDelegate_MembersInjector;
import com.haife.android.mcas.di.module.AppModule;
import com.haife.android.mcas.di.module.AppModule_ProvideAppManagerFactory;
import com.haife.android.mcas.di.module.AppModule_ProvideExtrasFactory;
import com.haife.android.mcas.di.module.AppModule_ProvideFragmentLifecyclesFactory;
import com.haife.android.mcas.di.module.AppModule_ProvideGsonFactory;
import com.haife.android.mcas.di.module.ClientModule;
import com.haife.android.mcas.di.module.ClientModule_ProRxErrorHandlerFactory;
import com.haife.android.mcas.di.module.ClientModule_ProvideClientBuilderFactory;
import com.haife.android.mcas.di.module.ClientModule_ProvideClientFactory;
import com.haife.android.mcas.di.module.ClientModule_ProvideRetrofitBuilderFactory;
import com.haife.android.mcas.di.module.ClientModule_ProvideRetrofitFactory;
import com.haife.android.mcas.di.module.ClientModule_ProvideRxCacheDirectoryFactory;
import com.haife.android.mcas.di.module.ClientModule_ProvideRxCacheFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideBaseUrlFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideCacheFactoryFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideCacheFileFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideExecutorServiceFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideFormatPrinterFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideGlobalHttpHandlerFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideGsonConfigurationFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideImageLoaderStrategyFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideInterceptorsFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideObtainServiceDelegateFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideOkhttpConfigurationFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvidePrintHttpLogLevelFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideResponseErrorListenerFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideRetrofitConfigurationFactory;
import com.haife.android.mcas.di.module.GlobalConfigModule_ProvideRxCacheConfigurationFactory;
import com.haife.android.mcas.http.GlobalHttpHandler;
import com.haife.android.mcas.http.imageloader.BaseImageLoaderStrategy;
import com.haife.android.mcas.http.imageloader.ImageLoader;
import com.haife.android.mcas.http.imageloader.ImageLoader_Factory;
import com.haife.android.mcas.http.log.FormatPrinter;
import com.haife.android.mcas.http.log.RequestInterceptor;
import com.haife.android.mcas.http.log.RequestInterceptor_Factory;
import com.haife.android.mcas.integration.ActivityLifecycle;
import com.haife.android.mcas.integration.ActivityLifecycle_Factory;
import com.haife.android.mcas.integration.AppManager;
import com.haife.android.mcas.integration.FragmentLifecycle;
import com.haife.android.mcas.integration.FragmentLifecycle_Factory;
import com.haife.android.mcas.integration.IRepositoryManager;
import com.haife.android.mcas.integration.RepositoryManager;
import com.haife.android.mcas.integration.RepositoryManager_Factory;
import com.haife.android.mcas.integration.cache.Cache;
import com.haife.android.mcas.integration.lifecycle.ActivityLifecycleForRxLifecycle;
import com.haife.android.mcas.integration.lifecycle.ActivityLifecycleForRxLifecycle_Factory;
import com.haife.android.mcas.integration.lifecycle.FragmentLifecycleForRxLifecycle;
import com.haife.android.mcas.integration.lifecycle.FragmentLifecycleForRxLifecycle_Factory;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import io.rx_cache2.internal.RxCache;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.listener.ResponseErrorListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Application application;

  private Provider<Application> applicationProvider;

  private Provider<AppManager> provideAppManagerProvider;

  private Provider<ClientModule.RetrofitConfiguration> provideRetrofitConfigurationProvider;

  private Provider<Retrofit.Builder> provideRetrofitBuilderProvider;

  private Provider<ClientModule.OkhttpConfiguration> provideOkhttpConfigurationProvider;

  private Provider<OkHttpClient.Builder> provideClientBuilderProvider;

  private Provider<GlobalHttpHandler> provideGlobalHttpHandlerProvider;

  private Provider<FormatPrinter> provideFormatPrinterProvider;

  private Provider<RequestInterceptor.Level> providePrintHttpLogLevelProvider;

  private Provider<RequestInterceptor> requestInterceptorProvider;

  private Provider<List<Interceptor>> provideInterceptorsProvider;

  private Provider<ExecutorService> provideExecutorServiceProvider;

  private Provider<OkHttpClient> provideClientProvider;

  private Provider<HttpUrl> provideBaseUrlProvider;

  private Provider<AppModule.GsonConfiguration> provideGsonConfigurationProvider;

  private Provider<Gson> provideGsonProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<ClientModule.RxCacheConfiguration> provideRxCacheConfigurationProvider;

  private Provider<File> provideCacheFileProvider;

  private Provider<File> provideRxCacheDirectoryProvider;

  private Provider<RxCache> provideRxCacheProvider;

  private Provider<Cache.Factory> provideCacheFactoryProvider;

  private Provider<IRepositoryManager.ObtainServiceDelegate> provideObtainServiceDelegateProvider;

  private Provider<RepositoryManager> repositoryManagerProvider;

  private Provider<ResponseErrorListener> provideResponseErrorListenerProvider;

  private Provider<RxErrorHandler> proRxErrorHandlerProvider;

  private Provider<BaseImageLoaderStrategy> provideImageLoaderStrategyProvider;

  private Provider<ImageLoader> imageLoaderProvider;

  private Provider<Cache<String, Object>> provideExtrasProvider;

  private Provider<FragmentLifecycle> fragmentLifecycleProvider;

  private Provider<List<FragmentManager.FragmentLifecycleCallbacks>>
      provideFragmentLifecyclesProvider;

  private Provider<ActivityLifecycle> activityLifecycleProvider;

  private Provider<FragmentLifecycleForRxLifecycle> fragmentLifecycleForRxLifecycleProvider;

  private Provider<ActivityLifecycleForRxLifecycle> activityLifecycleForRxLifecycleProvider;

  private DaggerAppComponent(Builder builder) {
    initialize(builder);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.application = builder.application;
    this.applicationProvider = InstanceFactory.create(builder.application);
    this.provideAppManagerProvider =
        DoubleCheck.provider(AppModule_ProvideAppManagerFactory.create(applicationProvider));
    this.provideRetrofitConfigurationProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideRetrofitConfigurationFactory.create(
                builder.globalConfigModule));
    this.provideRetrofitBuilderProvider =
        DoubleCheck.provider(ClientModule_ProvideRetrofitBuilderFactory.create());
    this.provideOkhttpConfigurationProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideOkhttpConfigurationFactory.create(
                builder.globalConfigModule));
    this.provideClientBuilderProvider =
        DoubleCheck.provider(ClientModule_ProvideClientBuilderFactory.create());
    this.provideGlobalHttpHandlerProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideGlobalHttpHandlerFactory.create(builder.globalConfigModule));
    this.provideFormatPrinterProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideFormatPrinterFactory.create(builder.globalConfigModule));
    this.providePrintHttpLogLevelProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvidePrintHttpLogLevelFactory.create(builder.globalConfigModule));
    this.requestInterceptorProvider =
        DoubleCheck.provider(
            RequestInterceptor_Factory.create(
                provideGlobalHttpHandlerProvider,
                provideFormatPrinterProvider,
                providePrintHttpLogLevelProvider));
    this.provideInterceptorsProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideInterceptorsFactory.create(builder.globalConfigModule));
    this.provideExecutorServiceProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideExecutorServiceFactory.create(builder.globalConfigModule));
    this.provideClientProvider =
        DoubleCheck.provider(
            ClientModule_ProvideClientFactory.create(
                applicationProvider,
                provideOkhttpConfigurationProvider,
                provideClientBuilderProvider,
                (Provider) requestInterceptorProvider,
                provideInterceptorsProvider,
                provideGlobalHttpHandlerProvider,
                provideExecutorServiceProvider));
    this.provideBaseUrlProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideBaseUrlFactory.create(builder.globalConfigModule));
    this.provideGsonConfigurationProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideGsonConfigurationFactory.create(builder.globalConfigModule));
    this.provideGsonProvider =
        DoubleCheck.provider(
            AppModule_ProvideGsonFactory.create(
                applicationProvider, provideGsonConfigurationProvider));
    this.provideRetrofitProvider =
        DoubleCheck.provider(
            ClientModule_ProvideRetrofitFactory.create(
                applicationProvider,
                provideRetrofitConfigurationProvider,
                provideRetrofitBuilderProvider,
                provideClientProvider,
                provideBaseUrlProvider,
                provideGsonProvider));
    this.provideRxCacheConfigurationProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideRxCacheConfigurationFactory.create(
                builder.globalConfigModule));
    this.provideCacheFileProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideCacheFileFactory.create(
                builder.globalConfigModule, applicationProvider));
    this.provideRxCacheDirectoryProvider =
        DoubleCheck.provider(
            ClientModule_ProvideRxCacheDirectoryFactory.create(provideCacheFileProvider));
    this.provideRxCacheProvider =
        DoubleCheck.provider(
            ClientModule_ProvideRxCacheFactory.create(
                applicationProvider,
                provideRxCacheConfigurationProvider,
                provideRxCacheDirectoryProvider,
                provideGsonProvider));
    this.provideCacheFactoryProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideCacheFactoryFactory.create(
                builder.globalConfigModule, applicationProvider));
    this.provideObtainServiceDelegateProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideObtainServiceDelegateFactory.create(
                builder.globalConfigModule));
    this.repositoryManagerProvider =
        DoubleCheck.provider(
            RepositoryManager_Factory.create(
                provideRetrofitProvider,
                provideRxCacheProvider,
                applicationProvider,
                provideCacheFactoryProvider,
                provideObtainServiceDelegateProvider));
    this.provideResponseErrorListenerProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideResponseErrorListenerFactory.create(
                builder.globalConfigModule));
    this.proRxErrorHandlerProvider =
        DoubleCheck.provider(
            ClientModule_ProRxErrorHandlerFactory.create(
                applicationProvider, provideResponseErrorListenerProvider));
    this.provideImageLoaderStrategyProvider =
        DoubleCheck.provider(
            GlobalConfigModule_ProvideImageLoaderStrategyFactory.create(
                builder.globalConfigModule));
    this.imageLoaderProvider =
        DoubleCheck.provider(ImageLoader_Factory.create(provideImageLoaderStrategyProvider));
    this.provideExtrasProvider =
        DoubleCheck.provider(AppModule_ProvideExtrasFactory.create(provideCacheFactoryProvider));
    this.fragmentLifecycleProvider = DoubleCheck.provider(FragmentLifecycle_Factory.create());
    this.provideFragmentLifecyclesProvider =
        DoubleCheck.provider(AppModule_ProvideFragmentLifecyclesFactory.create());
    this.activityLifecycleProvider =
        DoubleCheck.provider(
            ActivityLifecycle_Factory.create(
                provideAppManagerProvider,
                applicationProvider,
                provideExtrasProvider,
                (Provider) fragmentLifecycleProvider,
                provideFragmentLifecyclesProvider));
    this.fragmentLifecycleForRxLifecycleProvider =
        DoubleCheck.provider(FragmentLifecycleForRxLifecycle_Factory.create());
    this.activityLifecycleForRxLifecycleProvider =
        DoubleCheck.provider(
            ActivityLifecycleForRxLifecycle_Factory.create(
                fragmentLifecycleForRxLifecycleProvider));
  }

  @Override
  public Application application() {
    return application;
  }

  @Override
  public AppManager appManager() {
    return provideAppManagerProvider.get();
  }

  @Override
  public IRepositoryManager repositoryManager() {
    return repositoryManagerProvider.get();
  }

  @Override
  public RxErrorHandler rxErrorHandler() {
    return proRxErrorHandlerProvider.get();
  }

  @Override
  public ImageLoader imageLoader() {
    return imageLoaderProvider.get();
  }

  @Override
  public OkHttpClient okHttpClient() {
    return provideClientProvider.get();
  }

  @Override
  public Gson gson() {
    return provideGsonProvider.get();
  }

  @Override
  public File cacheFile() {
    return provideCacheFileProvider.get();
  }

  @Override
  public Cache<String, Object> extras() {
    return provideExtrasProvider.get();
  }

  @Override
  public Cache.Factory cacheFactory() {
    return provideCacheFactoryProvider.get();
  }

  @Override
  public ExecutorService executorService() {
    return provideExecutorServiceProvider.get();
  }

  @Override
  public void inject(AppDelegate delegate) {
    injectAppDelegate(delegate);
  }

  private AppDelegate injectAppDelegate(AppDelegate instance) {
    AppDelegate_MembersInjector.injectMActivityLifecycle(instance, activityLifecycleProvider.get());
    AppDelegate_MembersInjector.injectMActivityLifecycleForRxLifecycle(
        instance, activityLifecycleForRxLifecycleProvider.get());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private GlobalConfigModule globalConfigModule;

    private Application application;

    @Override
    public AppComponent build() {
      if (globalConfigModule == null) {
        throw new IllegalStateException(
            GlobalConfigModule.class.getCanonicalName() + " must be set");
      }
      if (application == null) {
        throw new IllegalStateException(Application.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public Builder globalConfigModule(GlobalConfigModule globalConfigModule) {
      this.globalConfigModule = Preconditions.checkNotNull(globalConfigModule);
      return this;
    }
  }
}
