package edu.hawking.service;

import edu.hawking.model.User;
import org.springframework.stereotype.Service;

/**
 * 杜皓君 created by 2021/4/23
 * UserService
 **/
@Service
public class UserService {

	User user;

	public void sayHi() {
		System.out.println("Hello Spring " );
	}
}
