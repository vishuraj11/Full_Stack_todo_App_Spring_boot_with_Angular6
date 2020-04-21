/**
 * 
 */
package com.todos.restfultodosservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todos.restfultodosservices.entity.AuthenticationBean;

/**
 * @author Rajendra.kushawaha
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api")
public class BasicAuthenticationController {

	@GetMapping("/basicauth")
	public AuthenticationBean basicAuth() {
		
		return new AuthenticationBean("you are authenticated");
		
	}

}
