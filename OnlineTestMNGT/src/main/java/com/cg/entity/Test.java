package com.cg.entity;

import java.math.*;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="test_table2")
public class Test {

	@Id
	private int testId ;
		
	@Column
	private String testTitle;
	@Column
	private String testDuration ;

	
	@Column
	private int testTotalMarks ;
	
	@Column
	private int testMarksScored ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionId")
	private Question currentQuestion ;
	
	@Column
	private String startTime ; 
	
	@Column
	private String endTime ;
	
	
	public Test(int testId, String testTitle, String testDuration,
			int testTotalMarks, int testMarksScored, String startTime,
			String endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		//this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		//this.currentQuestion = currentQuestion;
		this.startTime = startTime;
		this.endTime = endTime;
	}

   public Test()
   {}
	
	
	public int getTestId() {
		return testId;
	}


	public void setTestId(int testId) {
		this.testId = testId;
	}


	public String getTestTitle() {
		return testTitle;
	}


	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}


	public String getTestDuration() {
		return testDuration;
	}


	public void setTestDuration(String testDuration) {
		this.testDuration = testDuration;
	}


//	public Set<Question> getTestQuestions() {
//		return testQuestions;
//	}
//
//
//	public void setTestQuestions(Set<Question> testQuestions) {
//		this.testQuestions = testQuestions;
//	}


	public int getTestTotalMarks() {
		return testTotalMarks;
	}


	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}


	public int getTestMarksScored() {
		return testMarksScored;
	}


	public void setTestMarksScored(int testMarksScored) {
		this.testMarksScored = testMarksScored;
	}


	public Question getCurrentQuestion() {
		return currentQuestion;
	}


	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testQuestions=" + testTotalMarks + ", testMarksScored="
				+ testMarksScored + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
}
