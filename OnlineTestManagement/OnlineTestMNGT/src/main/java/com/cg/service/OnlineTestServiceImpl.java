package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.OnlineTestDaoI;
import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;

@Service
public class OnlineTestServiceImpl implements OnlineTestServiceI {

	@Autowired
	OnlineTestDaoI dao;

	@Override
	public void createQuestion(Question question) {
		dao.createQuestion(question);
	}


	@Override
	public List<Question> getQuestionList(BigInteger testId) {
		
		return dao.getQuestionList(testId);
	}

	@Override
	public List<Question> getAllQuestion() {
		
		return dao.getAllQuestion();
	}

	@Override
	public Question getOneQuestion(BigInteger questionId) {
		
		return dao.getOneQuestion(questionId);
	}

	@Override
	public void updateQuestion(Question question) {
		dao.updateQuestion(question);
		
	}

	@Override
	public void deleteQuestion(BigInteger questionId) {
		dao.deleteQuestion(questionId);
		
	}
	@Override
	public List<Result> getResult(int userId)
	{
	   return dao.getResult(userId);
	}	
	@Override
	public void createResult(Result result) {
		
		dao.createResult(result);
	}

	
}
