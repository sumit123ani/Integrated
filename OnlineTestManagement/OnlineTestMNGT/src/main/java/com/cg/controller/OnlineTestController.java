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
	
	@PostMapping(value="/question/new", consumes= {"application/json"})
	public String createQuestion(@RequestBody Question question,BindingResult bindingResult)  throws OnlineTestException
	{
		String err="";
		if(bindingResult.hasErrors())
		{
			List<FieldError> errors=bindingResult.getFieldErrors();
			for(FieldError error:errors)
			{
				err +=error.getDefaultMessage();
			}
			throw new OnlineTestException(err);
		}
	
	
	
	try{
		service.createQuestion(question);
		return "question created";
	}
	catch(DataIntegrityViolationException exception)
	{
		throw new OnlineTestException("id already exists");
	}
 }

	
	@GetMapping(value = "/question/{testId}")
	public List<Question> getQuestionList(@PathVariable BigInteger testId)
	{
		return service.getQuestionList(testId);
	}
	
	@GetMapping(value = "/question")
	public List<Question> getAllQuestion()
	{
		return service.getAllQuestion();
	}
	
	
	@GetMapping(value = "/question/{questionId}")
	public Question getOneQuestion(@PathVariable BigInteger questionId)
	{
		return service.getOneQuestion(questionId);
	}

	
	@PutMapping(value ="question/update", consumes= {"application/json"})
	public String updateQuestion(@RequestBody Question question)
	{
		service.updateQuestion(question);
		return "question updated";
	}
	
	
	@DeleteMapping(value = "question/delete/{questionId}")
	public String deleteQuestion(@PathVariable BigInteger questionId)
	{
		service.deleteQuestion(questionId);
		return "deleted";
	}
	@GetMapping(value ="/result/{userId}")
	public List<Result> getResult(@PathVariable int userId)
	{
	return service.getResult(userId);
	}
	@PostMapping(value = "/result/new", consumes = {"application/json"})
	public String createResult(@RequestBody Result result)
	{
		service.createResult(result);
		return "result created";
	}
}