package edu.hawking;

import edu.hawking.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * 杜皓君 created by 2021/4/23
 * Application
 **/
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		userService.sayHi();
		System.out.println("running");
	}
}
