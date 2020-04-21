/**
 * 
 */
package com.todos.restfultodosservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.todos.restfultodosservices.entity.Todo;

/**
 * @author Rajendra.kushawaha
 *
 */
@Service
public class HardcodedTodos {
	
	private static List<Todo> todos=new ArrayList<>();
	private static int idCounter=0;
	static {
		todos.add(new Todo(++idCounter,"rajendra", "learn dance", new Date(),false));
		todos.add(new Todo(++idCounter,"rajendra", "learn about Microservices", new Date(),false));
		todos.add(new Todo(++idCounter,"rajendra", "learn about angular", new Date(),false));

	}
	
	public List<Todo> findAll(){
		return todos;
	}
	
	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if(todo==null) return null;
		if(todos.remove(todo)) {
		  return todo;	
		}
		return null;
	}
	
	public Todo   findById(Long id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}

	public Todo getTodoById(long id) {
		
		Todo todo = findById(id);
		
		 if(todo==null) return null;
		
		return todo;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId()==-1 || todo.getId()==0) {
			todo.setId(++idCounter);
			todos.add(todo);
		}else{
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

}
