package com.yby.demo.domain;

public class QuizQuestion {
	private int quiz_question_id;
	private int quiz_type_id;
	private String content;
	public int getQuiz_question_id() {
		return quiz_question_id;
	}
	public void setQuiz_question_id(int quiz_question_id) {
		this.quiz_question_id = quiz_question_id;
	}
	public int getQuiz_type_id() {
		return quiz_type_id;
	}
	public void setQuiz_type_id(int quiz_type_id) {
		this.quiz_type_id = quiz_type_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
