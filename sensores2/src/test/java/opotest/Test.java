package opotest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	@org.junit.Test
	public void whenGetBeans_returnsBean() {
	    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:root-context.xml");
	    String[] names = applicationContext.getBeanDefinitionNames();
	 
	  
	   
	}
}
