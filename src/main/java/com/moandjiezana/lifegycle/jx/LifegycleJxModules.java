package com.moandjiezana.lifegycle.jx;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.nnsoft.guice.lifegycle.AfterInjectionModule;
import org.nnsoft.guice.lifegycle.DisposeModule;

import com.google.inject.matcher.Matchers;

/**
 * A factory to create Lifegycle modules configured to use standard annotations from the javax.annotations package
 * 
 * @author Moandji Ezana
 * @since 0.1
 */
public class LifegycleJxModules {

  /**
   * @return An {@link AfterInjectionModule} that uses the {@link PostConstruct} annotation to identify handlers.
   * @since 0.1
   */
  public static AfterInjectionModule afterInjectionModule() {
    return new AfterInjectionModule(PostConstruct.class, Matchers.any());
  }

  /**
   * @return A {@link DisposeModule} that uses a {@link PreDestroy} annotation to identify handlers.
   * @since 0.1
   */
  public static DisposeModule disposeModule() {
    return new DisposeModule(PreDestroy.class, Matchers.any());
  }
  
  private LifegycleJxModules() {}
}
