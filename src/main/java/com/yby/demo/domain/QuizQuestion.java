package com.yby.demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_question")
public class QuizQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUIZ_QUESTION_ID")
	private int quiz_question_id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUIZ_TYPE_ID", nullable = false, insertable = false,updatable = false)
	private QuizType quiz_type;


	@Column(name = "STATUS")
	private Boolean status;
	

	@Column(name = "QUIZ_TYPE_ID")
	private int quiz_type_id;
	
	
	public int getQuiz_type_id() {
		return quiz_type_id;
	}
	public void setQuiz_type_id(int quiz_type_id) {
		this.quiz_type_id = quiz_type_id;
	}
	
	
	@Column(name = "CONTENT")
	private String content;
	
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getQuiz_question_id() {
		return quiz_question_id;
	}
	public void setQuiz_question_id(int quiz_question_id) {
		this.quiz_question_id = quiz_question_id;
	}
	
	public QuizType getQuiz_type() {
		return quiz_type;
	}
	public void setQuiz_type(QuizType quiz_type) {
		this.quiz_type = quiz_type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
