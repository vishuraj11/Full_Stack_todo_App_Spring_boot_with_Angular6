/**
 * 
 */
package com.todos.restfultodosservices.entity;

import java.util.Date;

/**
 * @author Rajendra.kushawaha
 *
 */
public class TodoEntity {
	private String todoType;
	
	private Date todoDate;

	public String getTodoType() {
		return todoType;
	}

	public void setTodoType(String todoType) {
		this.todoType = todoType;
	}

	public Date getTodoDate() {
		return todoDate;
	}

	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
	
	
	
}
