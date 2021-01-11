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
@Table(name = "quiz_detail")
public class QuizDetail {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUIZ_DETAIL_ID")
	private int quizDetailId;
	
	@Column(name = "RESULT_ID")
	private int resultId;
	
	@Column(name = "QUESTION_ID")
	private int questionId;
	
	@Column(name = "CHOICE_ID")
	private Integer choiceId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CHOICE_ID", nullable = false, insertable = false,updatable = false)
	private QuizChoice choice;
	

	public QuizChoice getChoice() {
		return choice;
	}

	public void setChoice(QuizChoice choice) {
		this.choice = choice;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID", nullable = false, insertable = false,updatable = false)
	private QuizQuestion quizQuestion;



	public QuizQuestion getQuizQuestion() {
		return quizQuestion;
	}

	public void setQuizQuestion(QuizQuestion quizQuestion) {
		this.quizQuestion = quizQuestion;
	}


	public int getQuizDetailId() {
		return quizDetailId;
	}

	public void setQuizDetailId(int quizDetailId) {
		this.quizDetailId = quizDetailId;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Integer getChoiceId() {
		return choiceId;
	}

	public void setChoiceId(Integer choiceId) {
		this.choiceId = choiceId;
	}
	
}
