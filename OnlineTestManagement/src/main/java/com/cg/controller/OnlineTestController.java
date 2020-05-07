package com.cg.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.OnlineTestException;
import com.cg.service.OnlineTestServiceI;

@CrossOrigin
@RestController
public class OnlineTestController {

	@Autowired
	OnlineTestServiceI service;
	
	
	@PostMapping(value="/user/new", consumes= {"application/json"})
	public String createUser(@RequestBody User user)
	{
			 service.createUser(user);
			 return "user created";
	}
	
	
	@GetMapping(value="/user/{id}")
	public User getUser(@PathVariable BigInteger id)
	{
		return service.getUser(id);
	}
	
	
	@PostMapping(value="/test/new", consumes= {"application/json"})
	public String createTest(@RequestBody Test test)
	{
		service.createTest(test);
		return "test created";
	}
	
	
	@GetMapping(value="/test")
	public List<Test> getTestList()
	{
		return service.getAllTest();
	}
	
	
	@GetMapping(value="/test/{id}")
	public Test getOneTest(@PathVariable int id)
	{
		return service.getOneTest(id);
	}
	
	@PutMapping(value = "test/update", consumes = {"application/json"})
	public String updateTest(@RequestBody Test test) throws OnlineTestException
	{
		service.updateTest(test);
		return "updated successfully";
	}
	
	
	@PutMapping(value = "assign/test", consumes = {"application/json"})
	public String assignTest(@RequestBody Test test) throws OnlineTestException
	{
		service.asignTest(test);
		return "test assigned";
	}
	
	
	@PutMapping(value = "/add/question/test", consumes = {"application/json"})
	public String addQuestionToTest(@RequestBody Test test)
	{
		service.addQuestionTotTest(test);
		return "question added";
	}
	
	
	@DeleteMapping(value ="test/delete/{testId}")
	public String deleteTest(@PathVariable int testId)
	{
		service.deleteTest(testId);
		return "deletetd successfully"	;
	}
	
	
	@PostMapping(value = "/result/new", consumes = {"application/json"})
	public String createResult(@RequestBody Result result)
	{
		service.createResult(result);
		return "result created";
	}
	
	
	
	@GetMapping(value = "/question/list/{testId}")
	public List<Question> getQuestionList(@PathVariable BigInteger testId)
	{
		return service.getQuestionList(testId);
	}

	
	
	@GetMapping(value = "/question/{questionId}")
	public Question getOneQuestion(@PathVariable BigInteger questionId)
	{
		return service.getOneQuestion(questionId);
	}
	
	
	
	@PutMapping(value ="question/update", consumes= {"application/json"})
	public String updateQuestion(@RequestBody Question question) throws OnlineTestException
	{
		service.updateQuestion(question);
		return "question updated";
	}
	
	

	
	
}

