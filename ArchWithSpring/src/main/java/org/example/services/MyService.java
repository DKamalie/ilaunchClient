package org.example.services;

import org.example.domain.User;

import java.util.Set;

public interface MyService {

	String ask(String question);
	Set<User> getUsers(Set<User> users);
}
