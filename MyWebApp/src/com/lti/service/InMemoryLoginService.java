package com.lti.service;

import java.util.HashMap;

public class InMemoryLoginService {

	private HashMap<String, String> users = new HashMap<>();

	public InMemoryLoginService() {
		users.put("prajakta", "1296");																							//key-value pairs
		users.put("poonam", "123");
		users.put("ankita", "456");
	}

	public boolean isValidUser(String username, String password) {
		if (users.containsKey(username) && users.get(username).equals(password)) {         //get username and equate with password
			return true;
		} else {
			return false;
		}
	}
}
