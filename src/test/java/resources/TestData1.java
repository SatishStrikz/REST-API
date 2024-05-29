package resources;

import pojo.AddAuth;

public class TestData1 {

	public AddAuth addAuthentication(String username, String password) {
		AddAuth auth = new AddAuth();
		auth.setUsername(username);

		auth.setPassword(password);

		return auth;
	}

}
