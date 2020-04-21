/**
 * 
 */
package com.todos.restfultodosservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todos.restfultodosservices.entity.Todo;
import com.todos.restfultodosservices.service.HardcodedTodos;

/**
 * @author Rajendra.kushawaha
 *  http://localhost:8080/api/users/rajendra/todos
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api")
public class TodoResource {
 
	@Autowired 
	private HardcodedTodos hardcodedTodos; 
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		
		return hardcodedTodos.findAll();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id){
	 Todo todo=	hardcodedTodos.deleteById(id);
	 if(todo!=null) {
		 return ResponseEntity.noContent().build();
	 }
	 return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodoById(@PathVariable String username,@PathVariable long id) {
		
		return hardcodedTodos.getTodoById(id);
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,
			@PathVariable long id, @RequestBody Todo todo) {
		
		Todo todoUpdated=hardcodedTodos.save(todo);
		
		return new ResponseEntity<Todo>(todo,HttpStatus.OK);
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		
		Todo createdTodo=hardcodedTodos.save(todo);
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}

