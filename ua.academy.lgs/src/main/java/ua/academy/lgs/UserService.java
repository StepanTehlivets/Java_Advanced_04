package ua.academy.lgs;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<User> listOfUsers = new ArrayList<>();
	private static UserService userService;

	private UserService() {}

	public static UserService getUserService() {
		if(userService == null) {
			userService = new UserService();
		}
		return userService;
	}

	public List<User> getListOfUsers() {
		return listOfUsers;
	}

	public void saveUser(User user) {
		listOfUsers.add(user);
	}

	public User getUser(String email) {
		return listOfUsers.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
	}
	public User getUserByName(String name) {
		return listOfUsers.stream().filter(user -> user.getFirstName().equals(name)).findAny().orElse(null);
	}
	public User getUserByLogged(Boolean isLogged) {
		return listOfUsers.stream().filter(user -> user.isLogged()).findAny().orElse(null);
	}

}