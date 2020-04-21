/**
 * 
 */
package com.todos.restfultodosservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Rajendra.kushawaha
 *
 */
public class encryptString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		String str= encoder.encode("himanshi");
		System.out.println(str);
		

	}

}
