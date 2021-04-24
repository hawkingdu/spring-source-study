package edu.hawking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 杜皓君 created by 2021/4/23
 * Aservice
 **/
@Service
public class Aservice {

	@Autowired
	Bservice bservice;

	public Aservice() {
		System.out.println("调用Aservice()构造方法实例化");
	}

	public Bservice getBservice() {
		return bservice;
	}

	public void setBservice(Bservice bservice) {
		this.bservice = bservice;
	}
}
