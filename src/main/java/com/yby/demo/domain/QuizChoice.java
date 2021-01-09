package com.yby.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "choice")
public class QuizChoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CHOICE_ID")
	private int choice_id;
	
	@Column(name = "QUESTION_ID")
	private int question_id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID", nullable = false, insertable = false,updatable = false)
	private QuizQuestion quizQuestion;
	
	
	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}
	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "If_CORRECT")
	private boolean if_correct;
	
	
	
	public int getChoice_id() {
		return choice_id;
	}
	public void setChoice_id(int choice_id) {
		this.choice_id = choice_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isIf_correct() {
		return if_correct;
	}
	public void setIf_correct(boolean if_correct) {
		this.if_correct = if_correct;
	}
	

}
