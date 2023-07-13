package com.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<ToDo> todoList = new ArrayList<ToDo>();
	static {
		todoList.add(new ToDo(1, "admin", "Learn AWS", LocalDate.now().plusMonths(1), false));
		todoList.add(new ToDo(2, "admin", "Learn Spring Boot", LocalDate.now().plusDays(20), false));
		todoList.add(new ToDo(1, "admin", "Learn Azure", LocalDate.now().plusMonths(1), false));
	}
	
	public List<ToDo> findByUserName(String userName) {
		return todoList;
	}
}
