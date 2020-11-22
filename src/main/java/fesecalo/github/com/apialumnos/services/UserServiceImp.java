package fesecalo.github.com.apialumnos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import fesecalo.github.com.apialumnos.exception.RestServiceException;
import fesecalo.github.com.apialumnos.model.User;
import fesecalo.github.com.apialumnos.repository.UserRepository;
import fesecalo.github.com.apialumnos.security.JwtTokenProvider;
import java.util.List;

@Service
public class UserServiceImp implements UserService, UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public String signin(User user)
	{
		try
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
			return jwtTokenProvider.createToken(user.getUsername(),userRepository.findByUsername(user.getUsername()).getRoles());
		}
		catch (AuthenticationException e)
		{
			throw new RestServiceException("username o password invalido", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	public String signup(User user)
	{
		if (!userRepository.existsByUsername(user.getUsername()))
		{
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.createToken(user.getUsername(),user.getRoles());
		}
		else
		{
			throw new RestServiceException("Username ya está en uso",HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		final User user = userRepository.findByUsername(username);
		if (user == null)
		{
			throw new UsernameNotFoundException("Usuario '" + username + "' no encontrado");
		}
		
		return org.springframework.security.core.userdetails.User//
				.withUsername(username)
				.password(user.getPassword())
				.authorities(user.getRoles())
				.accountExpired(false)
				.accountLocked(false)
				.credentialsExpired(false)
				.disabled(false)
				.build();
	}
	
	@Override
	public void update(User user)
	{
		userRepository.save(user);
	}
	
	@Override
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id)
	{
		return userRepository.findById(id).orElse(new User());
	}
	
	@Override
	public void delete(User user)
	{
		userRepository.delete(user);
	}
}
