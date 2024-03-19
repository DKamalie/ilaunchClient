package org.example;

import org.example.api.UserApi;
import org.example.domain.User;
import org.example.services.MyService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.Collections;
import java.util.Set;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyViewModel {
	@WireVariable
	UserApi userApi = new UserApi();
	@WireVariable
	private MyService myService;
	private String answer;
	@WireVariable
	private Set<User> users;

	@Init
	public void init() {
		answer = "?";
		users = Collections.emptySet();
	}

	@Command
	@NotifyChange("answer")
	public void cmd() {
		answer = myService.ask("What day is today?");
	}
	@Command
	@NotifyChange("users")
	public void getUsers() {
		users = userApi.getAllUsers();
	}

	public Set<User> setUsers() {
		return users;
	}

	public String getAnswer() {
		return answer;
	}
}
