package com.haife.android.mcas.di.module;

import com.haife.android.mcas.http.log.FormatPrinter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GlobalConfigModule_ProvideFormatPrinterFactory
    implements Factory<FormatPrinter> {
  private final GlobalConfigModule module;

  public GlobalConfigModule_ProvideFormatPrinterFactory(GlobalConfigModule module) {
    this.module = module;
  }

  @Override
  public FormatPrinter get() {
    return provideInstance(module);
  }

  public static FormatPrinter provideInstance(GlobalConfigModule module) {
    return proxyProvideFormatPrinter(module);
  }

  public static GlobalConfigModule_ProvideFormatPrinterFactory create(GlobalConfigModule module) {
    return new GlobalConfigModule_ProvideFormatPrinterFactory(module);
  }

  public static FormatPrinter proxyProvideFormatPrinter(GlobalConfigModule instance) {
    return Preconditions.checkNotNull(
        instance.provideFormatPrinter(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
