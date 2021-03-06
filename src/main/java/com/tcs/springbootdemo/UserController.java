package com.tcs.springbootdemo;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);

	@Autowired
	IUserService userservice;

	@Autowired
	IUserRepository repo;

	@GetMapping("/user")
	public Iterable<User> getuser() {
		logger.error("Wow?");
		System.out.println("Hello");
		return userservice.getAllUsers();
	}

	@PostMapping("/user")
	@Transactional(rollbackFor = Exception.class)
	public void saveuser(@RequestBody @Valid User user) {
		// userservice.save(user);
		repo.save(user);
		System.out.println(user.getFirstName());
		throw new RuntimeException();

	}

	@ExceptionHandler(value = {UserNotFoundException.class, EmptyResultDataAccessException.class})
	public ResponseEntity<User> exception(RuntimeException userNotFoundException) {
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/user/{id}")
	private User getUser1(@PathVariable("id") Integer id) {
		Optional<User> user = repo.findById(id);
//		if (!user.isPresent()) {
//			throw new UserNotFoundException("user does not exist");
//		}
		return user.get();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		repo.deleteById(id);

	}
}
