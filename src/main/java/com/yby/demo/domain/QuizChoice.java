package com.yby.demo.domain;

public class QuizChoice {
	private int choice_id;
	private int question_id;
	private String content;
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
