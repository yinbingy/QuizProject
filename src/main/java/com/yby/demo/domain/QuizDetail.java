package com.yby.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
