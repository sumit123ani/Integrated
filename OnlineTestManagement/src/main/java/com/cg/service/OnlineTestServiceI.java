package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.OnlineTestException;

public interface OnlineTestServiceI {


	public void createUser(User user);
	public void createTest(Test test);
	
    public void createResult(Result result);
	public void addQuestionTotTest(Test test);
    
	public void asignTest(Test test) throws OnlineTestException;
	
 	
    public void updateQuestion(Question question) throws OnlineTestException;
    public void updateTest(Test test) throws OnlineTestException;
    
	public User getUser(BigInteger id);
	public List<Test> getAllTest();
	public List<Question> getQuestionList(BigInteger testId);
	
	public Test getOneTest(int id);
	public List<Question> getAllQuestion();
	public Question getOneQuestion(BigInteger questionId);
	

	public void deleteTest(int testId);
}
