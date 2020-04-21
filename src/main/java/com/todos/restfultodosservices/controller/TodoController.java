/**
 * 
 */
package com.todos.restfultodosservices.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todos.restfultodosservices.entity.TodoEntity;

/**
 * @author Rajendra.kushawaha
 *
 */
@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class TodoController {
	
	@GetMapping("/create-todo")
	public TodoEntity createTodo() {
		TodoEntity todoEntity=new TodoEntity();
		todoEntity.setTodoType("working on spring");
		todoEntity.setTodoDate(new Date());
		return todoEntity;
		
	}
	
	@GetMapping("/create-todo/{name}")
	public TodoEntity returnName(@PathVariable String name) {
		 TodoEntity todoEntity=new TodoEntity();
		todoEntity.setTodoType(name);
		return todoEntity;
	}
	
	

}
