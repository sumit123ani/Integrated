package com.cg.entity;

import java.io.Serializable;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question implements Serializable{

	@Id
	private BigInteger questionId ; 

//	@OneToOne(fetch = FetchType.LAZY, targetEntity = OptionList.class, cascade=CascadeType.ALL)
//	@JoinColumn(name="optionId", insertable = false, updatable = false)
//    private OptionList option;
	
	@Column(name = "options")
	private String[] option;

	@Column
	private String questionTitle ;
	
	@Column
	private String questionAnswer ;
	
	@Column
	private BigDecimal questionMarks ;
	
	@Column
	private String chosenAnswer ;
	
	@Column
	private BigDecimal marksScored ; 

	
	public Question()
	{
		
	}


	public Question(BigInteger questionId, String questionTitle,
			String questionAnswer, BigDecimal questionMarks, String chosenAnswer, BigDecimal marksScored) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
	}


	public BigInteger getQuestionId() {
		return questionId;
	}


	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}


	public String getQuestionTitle() {
		return questionTitle;
	}


	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	
	public String[] getOption() {
		return option;
	}


	public void setOption(String[] option) {
		this.option = option;
	}


	public String getQuestionAnswer() {
		return questionAnswer;
	}


	public void setQuestionAnswer(String questionAnswer) {
		this.questionAnswer = questionAnswer;
	}


	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}


	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}


	public String getChosenAnswer() {
		return chosenAnswer;
	}


	public void setChosenAnswer(String chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}


	public BigDecimal getMarksScored() {
		
		return marksScored;
	}


	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}

	

//	public OptionList getOption() {
//		return option;
//	}
//
//
//	public void setOption(OptionList option) {
//		this.option = option;
//	}


	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionTitle="
				+ questionTitle + ", questionAnswer=" + questionAnswer + ", questionMarks=" + questionMarks
				+ ", chosenAnswer=" + chosenAnswer + ", marksScored=" + marksScored + "]";
	}
	
	
	
}
