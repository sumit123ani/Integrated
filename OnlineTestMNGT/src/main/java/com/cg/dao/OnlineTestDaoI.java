package com.cg.dao;

import java.math.BigInteger;
import java.util.List;


import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;

public interface OnlineTestDaoI {


	public void createQuestion(Question question);
	public void updateQuestion(Question question);
	public List<Question> getQuestionList(BigInteger testId);
	public List<Question> getAllQuestion();
	public Question getOneQuestion(BigInteger questionId);
	public void deleteQuestion(BigInteger questionId);
	public List<Result> getResult(int userId);
	public void createResult(Result result);
	
}
