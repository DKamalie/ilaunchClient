package org.example.services.impl;

import org.example.api.UserApi;
import org.example.domain.User;
import org.example.services.MyService;
import java.text.DateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service("myService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyServiceImpl implements MyService {
	UserApi userApi = new UserApi();
	public String ask(String question) {
		return DateFormat.getDateInstance().format(new Date());
	}

	@Override
	public Set<User> getUsers(Set<User> users) {
		return userApi.getAllUsers();
	}

}
