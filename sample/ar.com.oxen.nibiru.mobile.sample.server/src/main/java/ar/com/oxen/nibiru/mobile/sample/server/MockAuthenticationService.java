package ar.com.oxen.nibiru.mobile.sample.server;

import java.util.HashMap;
import java.util.Map;

public class MockAuthenticationService {
	private Map<String, MockUserDto> users;

	public MockAuthenticationService() {
		super();
		this.users = new HashMap<String, MockUserDto>();
		this.addUser("pepe", "popo", "Pepe", "Sanchez");
		this.addUser("toto", "toto", "Toto", "s");
	}

	private void addUser(String username, String password, String firstName,
			String lastName) {
		this.users.put(username, new MockUserDto(username, password, firstName,
				lastName));
	}

	public MockUserDto login(MockUserDto dto) {
		MockUserDto user = this.users.get(dto.getUsername());

		if (user != null && user.getPassword().equals(dto.getPassword())) {
			return new MockUserDto(null, null, user.getFirstName(), user.getLastName());
		} else {
			return null;
		}
	}
}
