package eu.europa.ec.estat.esa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import eu.europa.ec.estat.esa.dto.UserDto;
import eu.europa.ec.estat.esa.exception.UserAlreadyExistException;
import eu.europa.ec.estat.esa.model.User;
//import eu.europa.ec.estat.esa.web.UserRegistrationDto;

public interface UserService extends UserDetailsService {

	List<User> getAllUsers();

	User findByEmail(String email);

//	User save(UserRegistrationDto registration);

	User getUserById(long id);

	void deleteUserById(long id);

	User registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException;

	Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
