package com.haife.android.mcas.http.log;

import com.haife.android.mcas.http.GlobalHttpHandler;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RequestInterceptor_Factory implements Factory<RequestInterceptor> {
  private final Provider<GlobalHttpHandler> mHandlerProvider;

  private final Provider<FormatPrinter> mPrinterProvider;

  private final Provider<RequestInterceptor.Level> printLevelProvider;

  public RequestInterceptor_Factory(
      Provider<GlobalHttpHandler> mHandlerProvider,
      Provider<FormatPrinter> mPrinterProvider,
      Provider<RequestInterceptor.Level> printLevelProvider) {
    this.mHandlerProvider = mHandlerProvider;
    this.mPrinterProvider = mPrinterProvider;
    this.printLevelProvider = printLevelProvider;
  }

  @Override
  public RequestInterceptor get() {
    return provideInstance(mHandlerProvider, mPrinterProvider, printLevelProvider);
  }

  public static RequestInterceptor provideInstance(
      Provider<GlobalHttpHandler> mHandlerProvider,
      Provider<FormatPrinter> mPrinterProvider,
      Provider<RequestInterceptor.Level> printLevelProvider) {
    RequestInterceptor instance = new RequestInterceptor();
    RequestInterceptor_MembersInjector.injectMHandler(instance, mHandlerProvider.get());
    RequestInterceptor_MembersInjector.injectMPrinter(instance, mPrinterProvider.get());
    RequestInterceptor_MembersInjector.injectPrintLevel(instance, printLevelProvider.get());
    return instance;
  }

  public static RequestInterceptor_Factory create(
      Provider<GlobalHttpHandler> mHandlerProvider,
      Provider<FormatPrinter> mPrinterProvider,
      Provider<RequestInterceptor.Level> printLevelProvider) {
    return new RequestInterceptor_Factory(mHandlerProvider, mPrinterProvider, printLevelProvider);
  }

  public static RequestInterceptor newRequestInterceptor() {
    return new RequestInterceptor();
  }
}
