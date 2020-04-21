package com.todos.restfultodosservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		
		inMemoryUserList.add(new JwtUserDetails(1L, "rajendra", "$2a$10$It4lyQ/Izr2SNKbP.2WXWeimgjaahrkwFLCfwRHzMk7Y5/M5Aeg1e", "user 1"));
		inMemoryUserList.add(new JwtUserDetails(1L, "anjali", "$2a$10$EXywPC36j7EejrQ7ZadrWeDg7OeaBar38JgOxwbGeG7HigbkKUzNW", "user 2"));
		inMemoryUserList.add(new JwtUserDetails(1L, "himanshi","$2a$10$KgJq1BfYbh92iteHXVQm/uyS4EQUGVZHBGQH2vGHmHEd1Uh5SIdLK", "user 3"));
		
		/*{
			"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWplbmRyYSIsImV4cCI6MTU2NTg2MjkxMywiaWF0IjoxNTY1MjU4MTEzfQ.9Z1JW5r-JgtZYHJ4v3MdmMQvjGmeYQpRUDU27gmVJhn8tnqymKUTZr-YEEQfzZ4XIfwIF9rlUEHcKFb8ZE0iXA"
			}*/
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
