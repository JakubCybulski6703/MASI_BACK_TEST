package masi_green.manager;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masi_green.entity.ApplicationUser;
import masi_green.entity.UserSession;
import masi_green.model.request.LoginUserRequest;
import masi_green.model.response.BaseObjectResponse;
import masi_green.model.response.LoginUserResponse;
import masi_green.repository.ApplicationUserRepository;
import masi_green.repository.UserSessionRepository;
import masi_green.tools.CommonTools;

@Service
public class LoginUserManager {

	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	UserSessionRepository userSessionRepository;

	@SuppressWarnings("rawtypes")
	public BaseObjectResponse<LoginUserResponse> login(LoginUserRequest request) {
		final ApplicationUser user = applicationUserRepository.findByLogin(request.getLogin(),
				CommonTools.generateMD5(request.getPassword()));
		final BaseObjectResponse<LoginUserResponse> response = new BaseObjectResponse<LoginUserResponse>();
		if(user != null) {
			final UserSession session = new UserSession();
			session.setApplicationUser(user);
			final String token = CommonTools.generateSessionToken();
			session.setToken(token);
			session.setAddDate(new Timestamp(System.currentTimeMillis()));
			userSessionRepository.save(session);
			
			final LoginUserResponse loginUserResponse = new LoginUserResponse(token);
			response.setCode(1);
			response.setMessage("OK");
			response.setResponse(loginUserResponse);
		} else {
			response.setCode(2);
			response.setMessage("Credentials are incorrect");
		}
		
		return response;
	}
}
