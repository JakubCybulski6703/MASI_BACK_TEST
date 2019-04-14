package masi_green.manager;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import masi_green.entity.ApplicationUser;
import masi_green.entity.UserType;
import masi_green.model.request.RegisterUserRequest;
import masi_green.model.response.BaseObjectResponse;
import masi_green.repository.ApplicationUserRepository;
import masi_green.repository.UserTypeRepository;
import masi_green.tools.CommonTools;

@Service
public class RegisterUserManager {

	@Autowired
	ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	UserTypeRepository userTypeRepository;
	
	@SuppressWarnings("rawtypes")
	public BaseObjectResponse registerUser(RegisterUserRequest request) {
		final UserType userType = userTypeRepository.findById(1);
		final ApplicationUser user = new ApplicationUser();
		user.setLogin(request.getLogin());
		user.setPassword(CommonTools.generateMD5(request.getPassword()));
		user.setName(request.getName());
		user.setSurname(request.getSurname());
		user.setEmail(request.getEmail());
		user.setActive(true);
		user.setUserType(userType);
		user.setAddDate(new Timestamp(System.currentTimeMillis()));
		applicationUserRepository.save(user);
		
		final BaseObjectResponse response = new BaseObjectResponse();
		response.setCode(1);
		response.setMessage("OK");
		return response;
	}
}
