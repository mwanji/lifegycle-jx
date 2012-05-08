package com.moandjiezana.lifegycle.jx;

import static com.moandjiezana.lifegycle.jx.LifegycleJxModules.*;
import static org.junit.Assert.assertTrue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.Test;
import org.nnsoft.guice.lifegycle.Disposer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.moandjiezana.lifegycle.jx.LifegycleJxModules;

public class LifegycleJxModuleTest {

  @Test
  public void should_call_post_construct_handler() {
    Injector injector = Guice.createInjector(LifegycleJxModules.afterInjectionModule());
    
    PostConstructManaged postConstructManaged = injector.getInstance(PostConstructManaged.class);
    
    assertTrue("@PostConstruct handler was not called", postConstructManaged.postConstructCalled);
  }
  
  @Test
  public void should_call_pre_destroy_handler() {
    Injector injector = Guice.createInjector(LifegycleJxModules.disposeModule());
    
    PreDestroyManaged preDestroyManaged = injector.getInstance(PreDestroyManaged.class);
    
    injector.getInstance(Disposer.class).dispose();
    
    assertTrue("@PreDestroy handler was not called", preDestroyManaged.preDestroyCalled);
  }
  
  @Test
  public void should_call_both_handlers() {
    Injector injector = Guice.createInjector(afterInjectionModule(), disposeModule());
    
    FullyManaged fullyManaged = injector.getInstance(FullyManaged.class);
    
    injector.getInstance(Disposer.class).dispose();
    
    assertTrue("@PostConstruct handler was not called", fullyManaged.postConstructCalled);
    assertTrue("@PreDestroy handler was not called", fullyManaged.preDestroyCalled);
  }
  
  public static class PostConstructManaged {
    public boolean postConstructCalled;

    @PostConstruct
    public void postConstruct() {
      this.postConstructCalled = true;
    }
  }
  
  public static class PreDestroyManaged {
    public boolean preDestroyCalled;

    @PreDestroy
    public void predestroy() {
      this.preDestroyCalled = true;
    }
  }
  
  public static class FullyManaged {
    public boolean postConstructCalled;
    public boolean preDestroyCalled;

    @PostConstruct
    public void postConstruct() {
      this.postConstructCalled = true;
    }

    @PreDestroy
    public void predestroy() {
      this.preDestroyCalled = true;
    }
  }
}
