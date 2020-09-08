package eu.europa.ec.estat.esa.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import eu.europa.ec.estat.esa.model.User;
import eu.europa.ec.estat.esa.web.UserRegistrationDto;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
