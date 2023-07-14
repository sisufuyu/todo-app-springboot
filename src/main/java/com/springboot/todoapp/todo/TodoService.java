package com.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<ToDo> todoList = new ArrayList<ToDo>();
	
	private static int count = 0;
	static {
		todoList.add(new ToDo(++count, "sisu", "Learn AWS", LocalDate.now().plusMonths(1), false));
		todoList.add(new ToDo(++count, "sisu", "Learn Spring Boot", LocalDate.now().plusDays(20), false));
		todoList.add(new ToDo(++count, "sisu", "Learn Azure", LocalDate.now().plusMonths(1), false));
	}
	
	public List<ToDo> findByUserName(String username) {
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equals(username);
		return todoList.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username,String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++count, username, description, targetDate, done);
		todoList.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		todoList.removeIf(predicate);
	}
	
	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		return todoList.stream().filter(predicate).findFirst().get();
	}
	
	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todoList.add(todo);
	}
}
