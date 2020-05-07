package com.cg.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;
import com.cg.exception.OnlineTestException;

@Repository
@Transactional
public class OnlineTestDaoImpl implements OnlineTestDaoI {

	@PersistenceContext
	EntityManager manager;
	
	
	//
	@Override
	public void createUser(User user) {
		manager.persist(user);
	}

	@Override
	public void createTest(Test test) {
	  manager.persist(test);
	}

	@Override
	public List<Test> getAllTest() {
		Query query = manager.createQuery("from Test t");
		return query.getResultList();
	}

	@Override
	public String updateUser(User user) {
		
		User user1 = manager.find(User.class, user.getUserId());
		if(user1 != null)
		{
			
			user1.setUserName(user.getUserName());
			user1.setUserPassword(user.getUserPassword());
			user1.setIsAdmin(user.getIsAdmin());
			return "user updated succesfully";
		}
		else
		{
			return "user not found";
		}
	}

	@Override
	public User getUser(BigInteger id) {
		User user1 = manager.find(User.class, id);
		return user1;
	}


	@Override
	public Test getTest(int id) {
		
		return manager.find(Test.class, id);
	}


	
	@Override
	public List<Question> getQuestionList(BigInteger testId) {
		
		Query query = manager.createQuery("from Question que where test_fk ="+testId);
		return query.getResultList();
	}



	@Override
	public Question getOneQuestion(BigInteger questionId) {
		
		return manager.find(Question.class, questionId);
	}

	@Override
	public void updateQuestion(Question question) throws OnlineTestException {

		Question newQuestion = manager.find(Question.class, question.getQuestionId());
		
		if(newQuestion != null)
		{
		//newQuestion.setQuestionId(question.getQuestionId());
		newQuestion.setChosenAnswer(question.getChosenAnswer());
		newQuestion.setMarksScored(question.getMarksScored());
		newQuestion.setOption(question.getOption());
		newQuestion.setQuestionMarks(question.getQuestionMarks());
		newQuestion.setQuestionTitle(question.getQuestionTitle());
		newQuestion.setQuestionAnswer(question.getQuestionAnswer());
		
	
		}
		
		else
		{
			throw new OnlineTestException("No such question exists");
		}
	}

//	@Override
//	public void deleteQuestion(BigInteger questionId) {
//		
//		Question question = manager.find(Question.class, questionId);
//		manager.remove(question);
//	}

	@Override
	public void updateTest(Test test) throws OnlineTestException {
		
		Test newTest = manager.find(Test.class, test.getTestId())	;
		
		if(newTest != null)
		{
			newTest.setTestTitle(test.getTestTitle());
			newTest.setTestDuration(test.getTestDuration());
			
			newTest.setStartTime(test.getStartTime());
			newTest.setEndTime(test.getEndTime());
			newTest.setTestMarksScored(test.getTestMarksScored());
			newTest.setTestTotalMarks(test.getTestTotalMarks());
			
		}
		
		else
		{
			throw new OnlineTestException("No such test exists");
		}
	}

	
	@Override
	public void asignTest(Test test) throws OnlineTestException {
		
     Test newTest  = manager.find(Test.class, test.getTestId());
     
     if(newTest != null)
		newTest.setTestMarksScored(test.getTestMarksScored());
     
     else
    	 throw new OnlineTestException("no such test to assign");
	}

	
	@Override
	public void deleteTest(int testId) {
		
		manager.remove(manager.find(Test.class, testId));
	}

	@Override
	public void createResult(Result result) {
		
		manager.persist(result);
	}

	@Override
	public void createQuestion(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addQuestionToTest(Test test) throws OnlineTestException{

		try
		{
          Test newTest = manager.find(Test.class, test.getTestId());
         // newTest.setTestQuestions(null);
          
          Set<Question> set = test.getTestQuestions();
          
          for(Question question:set) {
        	  
           Query query = manager.createNativeQuery("delete from question where question_id ="+question.getQuestionId());
           System.out.println(query.executeUpdate());
          }
          
          newTest.setTestQuestions(test.getTestQuestions());
		}
		catch(DataIntegrityViolationException ex)
		{
			throw new OnlineTestException("question already exists");
		}
	}


	@Override
	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuestion(BigInteger questionId) {
		// TODO Auto-generated method stub
		
	}

	
	
}
