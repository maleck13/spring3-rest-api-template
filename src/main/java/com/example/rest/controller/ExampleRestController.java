package com.example.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.rest.model.Example;
import com.example.rest.response.ApiResponse;
import com.example.rest.service.ExampleService;
import java.util.ListIterator;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@RequestMapping(value="/example")
public class ExampleRestController {

	@Autowired
	private ExampleService exampleService;
	
	
	
	@RequestMapping(value="/create", method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ApiResponse create(@RequestBody @Valid Example example) {
		return new ApiResponse(HttpStatus.OK,exampleService.create(example));
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ApiResponse edit(@PathVariable int id, @RequestBody Example example) {
		example.setId(id);
		return new ApiResponse(HttpStatus.OK, "ok",exampleService.update(example));
	}
	
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Example deleteSmartphone(@PathVariable int id) {
		return exampleService.delete(id);
	}
	
	
	
	@RequestMapping(value="", method=RequestMethod.GET,
			produces = "application/json")
	@ResponseBody
	public List<Example> all() {
		return exampleService.getAll();
	}
	
}
