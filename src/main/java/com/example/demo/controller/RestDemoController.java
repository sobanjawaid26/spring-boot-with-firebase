package com.example.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FirebaseService;

import com.example.demo.domain.Person;



@RestController
public class RestDemoController {

	@Autowired
	private FirebaseService firebaseService;

	@GetMapping("/getUserDetails")
	public Person getExample(@RequestHeader() String name) throws InterruptedException, ExecutionException {
		return firebaseService.getUserDetails(name);
	}

	@PostMapping("/createUser")
	public String postExample(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return firebaseService.saveUserDetails(person);
	}

	@PutMapping("/updateUser")
	public String putExample(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return firebaseService.updateUserDetails(person);
	}

	@DeleteMapping("/deleteUser")
	public String deleteExample(@RequestHeader String name) {
		return firebaseService.deleteUser(name);
	}

}
