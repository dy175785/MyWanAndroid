package com.haife.android.mcas.di.module;

import androidx.fragment.app.FragmentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.annotation.Generated;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppModule_ProvideFragmentLifecyclesFactory
    implements Factory<List<FragmentManager.FragmentLifecycleCallbacks>> {
  private static final AppModule_ProvideFragmentLifecyclesFactory INSTANCE =
      new AppModule_ProvideFragmentLifecyclesFactory();

  @Override
  public List<FragmentManager.FragmentLifecycleCallbacks> get() {
    return provideInstance();
  }

  public static List<FragmentManager.FragmentLifecycleCallbacks> provideInstance() {
    return proxyProvideFragmentLifecycles();
  }

  public static AppModule_ProvideFragmentLifecyclesFactory create() {
    return INSTANCE;
  }

  public static List<FragmentManager.FragmentLifecycleCallbacks> proxyProvideFragmentLifecycles() {
    return Preconditions.checkNotNull(
        AppModule.provideFragmentLifecycles(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
