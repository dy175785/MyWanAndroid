package com.haife.android.mcas.http.log;

import com.haife.android.mcas.http.GlobalHttpHandler;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RequestInterceptor_MembersInjector
    implements MembersInjector<RequestInterceptor> {
  private final Provider<GlobalHttpHandler> mHandlerProvider;

  private final Provider<FormatPrinter> mPrinterProvider;

  private final Provider<RequestInterceptor.Level> printLevelProvider;

  public RequestInterceptor_MembersInjector(
      Provider<GlobalHttpHandler> mHandlerProvider,
      Provider<FormatPrinter> mPrinterProvider,
      Provider<RequestInterceptor.Level> printLevelProvider) {
    this.mHandlerProvider = mHandlerProvider;
    this.mPrinterProvider = mPrinterProvider;
    this.printLevelProvider = printLevelProvider;
  }

  public static MembersInjector<RequestInterceptor> create(
      Provider<GlobalHttpHandler> mHandlerProvider,
      Provider<FormatPrinter> mPrinterProvider,
      Provider<RequestInterceptor.Level> printLevelProvider) {
    return new RequestInterceptor_MembersInjector(
        mHandlerProvider, mPrinterProvider, printLevelProvider);
  }

  @Override
  public void injectMembers(RequestInterceptor instance) {
    injectMHandler(instance, mHandlerProvider.get());
    injectMPrinter(instance, mPrinterProvider.get());
    injectPrintLevel(instance, printLevelProvider.get());
  }

  public static void injectMHandler(RequestInterceptor instance, GlobalHttpHandler mHandler) {
    instance.mHandler = mHandler;
  }

  public static void injectMPrinter(RequestInterceptor instance, FormatPrinter mPrinter) {
    instance.mPrinter = mPrinter;
  }

  public static void injectPrintLevel(
      RequestInterceptor instance, RequestInterceptor.Level printLevel) {
    instance.printLevel = printLevel;
  }
}
