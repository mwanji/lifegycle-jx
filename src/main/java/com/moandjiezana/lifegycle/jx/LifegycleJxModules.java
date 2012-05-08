package com.moandjiezana.lifegycle.jx;

/*
 *  Copyright 2012 Moandji Ezana
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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
