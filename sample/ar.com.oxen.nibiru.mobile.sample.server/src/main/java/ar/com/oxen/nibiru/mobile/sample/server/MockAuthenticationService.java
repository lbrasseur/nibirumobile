package ar.com.oxen.nibiru.mobile.sample.server;

import java.util.HashMap;
import java.util.Map;

public class MockAuthenticationService {
	private final Map<String, MockUserDto> users;

	public MockAuthenticationService() {
		users = new HashMap<String, MockUserDto>();
		addUser("g", "g", "Rick", "Hunter");
	}

	private void addUser(String username, String password, String firstName,
			String lastName) {
		users.put(username, new MockUserDto(username, password, firstName,
				lastName));
	}

	public MockUserDto login(MockUserDto dto) {
		MockUserDto user = users.get(dto.getUsername());

		if (user != null && user.getPassword().equals(dto.getPassword())) {
			return new MockUserDto(null, null, user.getFirstName(), user.getLastName());
		} else {
			return null;
		}
	}
}
