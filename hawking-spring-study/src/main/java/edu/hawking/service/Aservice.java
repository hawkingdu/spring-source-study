package edu.hawking.service;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 杜皓君 created by 2021/4/23
 * Aservice
 **/
@Service
public class Aservice implements BeanNameAware {

	@Autowired
	Bservice bservice;

	public Aservice() {
		System.out.println("调用Aservice()构造方法实例化");
	}


	public void sayHi() {
		System.out.println("I'm Aservice");
	}

	@Override
	public void setBeanName(String name) {
		System.out.printf("BeanNameAware----my name is" + name);
	}
}
