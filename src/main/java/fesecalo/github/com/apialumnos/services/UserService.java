package fesecalo.github.com.apialumnos.services;

import org.springframework.security.core.userdetails.UserDetails;
import fesecalo.github.com.apialumnos.model.User;
import java.util.List;

public interface UserService
{
	String signin(User user);
	String signup(User user);
	
	void update(User user);
	List<User> findAll();
	User findById(Long id);
	void delete(User user);
	UserDetails loadUserByUsername(String username);
}