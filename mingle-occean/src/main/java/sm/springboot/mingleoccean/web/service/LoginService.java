package sm.springboot.mingleoccean.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userName, String password) {
		return "dummy".equalsIgnoreCase(userName) &&
				"dummy".equalsIgnoreCase(password);
	}
}
