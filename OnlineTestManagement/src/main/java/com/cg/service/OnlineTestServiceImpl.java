package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.cg.dao.OnlineTestDaoI;
import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.OnlineTestException;

@Service
public class OnlineTestServiceImpl implements OnlineTestServiceI {

	@Autowired
	OnlineTestDaoI dao;
	
	
	//value of user came from controller(server) and from here it will go to dao layer
	//and it will be persite in table through entity manager
	@Override
	public void createUser(User user) throws OnlineTestException{
		try {
	   dao.createUser(user);
	   }
		catch (DataIntegrityViolationException exception) {
		
			throw new OnlineTestException("id already is");
		}
	
	}

	
	//value of test came from controller and go to dao layer and 
	//it will be persiste in table through entity manager
	@Override
	public void createTest(Test test) {
		try
		{
		dao.createTest(test);
		}
		catch(DataIntegrityViolationException exception)
		{
			throw new OnlineTestException("Test already exists");
		}
	}

	
	// user requested to get list of all question
	// passed to dao layer and it will serach in table and return result
	@Override
	public List<Test> getAllTest() throws OnlineTestException{
		try
		{
		return dao.getAllTest();
		}
		catch (NullPointerException nullException) {

         throw new OnlineTestException("No test avaliable");
		}
	}
	
	
	// user requested to get a user
	// id is passed to dao layer and it will serach in table and return result
	@Override
	public User getUser(BigInteger id) throws OnlineTestException {

		User user = dao.getUser(id);
        if(user != null)
        {
		return dao.getUser(id);
        }
        else {
			
        	throw new OnlineTestException("No such user exists");
		}
	}


	
//id came from controoler user has requeste to get on question 
	//id will be passed to dao layer and result will be retuned
	@Override
	public List<Question> getQuestionList(BigInteger testId) {
		
		return dao.getQuestionList(testId);
	}

	
	//user has requeste to get all question 
	//it will be passed to dao layer and result will be retuned
	@Override
	public List<Question> getAllQuestion() {
		
		return dao.getAllQuestion();
	}

	@Override
	public Question getOneQuestion(BigInteger questionId) {
		
		return dao.getOneQuestion(questionId);
	}

	@Override
	public void updateQuestion(Question question) throws OnlineTestException {
		dao.updateQuestion(question);
		
	}


	
	//update request came from user and go to dao layer and 
	// test details will be updated 
	@Override
	public void updateTest(Test test) throws OnlineTestException {
		
		dao.updateTest(test);
	}

	
	
	@Override
	public void asignTest(Test test) throws OnlineTestException {

        dao.asignTest(test);
		
	}

	@Override
	public void deleteTest(int testId) {
	
	  dao.deleteTest(testId);	
	}

	
	//user requested to put an entry in result table
	//an object of result passed to dao layer and itt will be created
	@Override
	public void createResult(Result result) {
		
		dao.createResult(result);
	}

	//user requested to add question to test 
	// it passes new test which consits of new questions and it will go to 
	//dao and test will be updated with new question
	@Override
	public void addQuestionTotTest(Test test) {

         dao.addQuestionToTest(test);
		
	}

	@Override
	public Test getOneTest(int id) {
		
		return dao.getTest(id);
	}

	
}
