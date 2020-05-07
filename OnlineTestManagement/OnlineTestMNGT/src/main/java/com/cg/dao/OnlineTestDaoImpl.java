package com.cg.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.cg.entity.Question;
import com.cg.entity.Result;
import com.cg.entity.Test;
import com.cg.entity.User;

@Repository
@Transactional
public class OnlineTestDaoImpl implements OnlineTestDaoI {

	@PersistenceContext
	EntityManager manager;

	@Override
	public void createQuestion(Question question) {
		manager.persist(question);
	}


	@Override
	public List<Question> getQuestionList(BigInteger testId) {
		// TODO Auto-generated method stub
		Query query = manager.createQuery("from Question que where test_fk ="+testId);
		return query.getResultList();
	}

	
	@Override
	public List<Question> getAllQuestion() {

        Query query = manager.createQuery("from Question que");
		return query.getResultList();
	}

	@Override
	public Question getOneQuestion(BigInteger questionId) {
		
		return manager.find(Question.class, questionId);
	}

	@Override
	public void updateQuestion(Question question) {

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
		
	}

	@Override
	public void deleteQuestion(BigInteger questionId) {
		
//		Question question = manager.find(Question.class, questionId);
//		manager.remove(question);
		
		Query query = manager.createNativeQuery("delete from question where question_id ="+questionId);
		query.executeUpdate();
	}
	@Override
	public List<Result> getResult(int userId)
{
     Query query  = manager.createQuery("from Result r where r.userId = "+userId);
     return query.getResultList();
}
	@Override
	public void createResult(Result result) {
		
		manager.persist(result);
	}

}
