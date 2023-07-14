package com.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model){
		String username = getLoggedInUserName();
		List<ToDo> todoList= todoService.findByUserName(username);
		
		model.put("todos", todoList);

		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model){
		String username = getLoggedInUserName();
		ToDo todo = new ToDo(0, username, "", LocalDate.now(), false);
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid @ModelAttribute("todo")ToDo todo, BindingResult result){
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUserName();
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoService.deleteById(id);

		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
		ToDo todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid @ModelAttribute("todo")ToDo todo, BindingResult result){
		if (result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUserName();
		todo.setUsername(username);
		todo.setDone(false);
		
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUserName() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
