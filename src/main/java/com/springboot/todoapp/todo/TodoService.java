package com.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todoList = new ArrayList<Todo>();
	
	private static int count = 0;
	static {
		todoList.add(new Todo(++count, "sisu", "Learn AWS", LocalDate.now().plusMonths(1), false));
		todoList.add(new Todo(++count, "sisu", "Learn Spring Boot", LocalDate.now().plusDays(20), false));
		todoList.add(new Todo(++count, "sisu", "Learn Azure", LocalDate.now().plusMonths(1), false));
	}
	
	public List<Todo> findByUserName(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equals(username);
		return todoList.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++count, username, description, targetDate, done);
		todoList.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todoList.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todoList.stream().filter(predicate).findFirst().get();
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todoList.add(todo);
	}
}
