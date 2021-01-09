package com.yby.demo.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_type")
public class QuizType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_ID")
	private Integer type_id;
	
	@Column(name = "TYPE_NAME")
	private String type_name;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "quiz_type")
	private Set<QuizQuestion> quiz_questions = new HashSet<QuizQuestion> (0);
	
	public Integer getType_id() {
		return type_id;
	}
	public Set<QuizQuestion> getQuiz_questions() {
		return quiz_questions;
	}
	public void setQuiz_questions(Set<QuizQuestion> quiz_questions) {
		this.quiz_questions = quiz_questions;
	}
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
}
