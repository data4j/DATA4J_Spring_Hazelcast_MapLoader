package org.data4j.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ApplicationContextUtil Class provides access to application context.
 * 
 * @author data4j.org
 * @since 15 Oct 2013
 * @version 1.0.0
 *
 */
public class ApplicationContextUtil implements ApplicationContextAware {
 
  private static ApplicationContext applicationContext;
 
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
  
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	  ApplicationContextUtil.applicationContext = applicationContext; 
  } 
  
}