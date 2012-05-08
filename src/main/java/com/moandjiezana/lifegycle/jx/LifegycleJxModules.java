package com.moandjiezana.lifegycle.jx;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.nnsoft.guice.lifegycle.AfterInjectionModule;
import org.nnsoft.guice.lifegycle.DisposeModule;

import com.google.inject.matcher.Matchers;

public class LifegycleJxModules {

  public static AfterInjectionModule afterInjectionModule() {
    return new AfterInjectionModule(PostConstruct.class, Matchers.any());
  }

  public static DisposeModule disposeModule() {
    return new DisposeModule(PreDestroy.class, Matchers.any());
  }
}
