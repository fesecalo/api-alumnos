package fesecalo.github.com.apialumnos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import fesecalo.github.com.apialumnos.model.User;
import fesecalo.github.com.apialumnos.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/signin")
	public String login(@RequestBody User user)
	{
		return userService.signin(user);
	}
	
	@PostMapping("/signup")
	@ResponseStatus(HttpStatus.CREATED)
	public String signup(@RequestBody User user)
	{
		return userService.signup(user);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAll()
	{
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findOne(@PathVariable Long id)
	{
		return userService.findById(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody User userDTO)
	{
		userService.update(userDTO);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public void delete(@RequestBody User userDTO)
	{
		userService.delete(userDTO);
	}
}