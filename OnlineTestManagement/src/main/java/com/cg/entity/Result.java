package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class Result {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int resultId;
	
	@Column
	private int userId;
	
	@Column
	private int testId;
	
	@Column
	private double totalScore;
	
	@Column
	private double totalMarks;
	
	@Column
	private String testTitle;
	
	public Result() {
		super();
	}

	public Result(int userId, int testId, double totalScore, double totalMarks) {
		super();
		this.userId = userId;
		this.testId = testId;
		this.totalScore = totalScore;
		this.totalMarks = totalMarks;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(double totalMarks) {
		this.totalMarks = totalMarks;
	}

	
	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	
	@Override
	public String toString() {
		return "Result [userId=" + userId + ", testId=" + testId + ", totalScore=" + totalScore + ", totalMarks="
				+ totalMarks + "]";
	}
	
	

}
