package com.yby.demo.domain;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FEEDBACK_ID")
	private int feedbackId;
	
	@Column(name = "FEEDBACK_Content")
	private String feedbackContent;
	
	@Column(name = "FEEDBACK_STAR")
	private int feedbackStar;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public int getFeedbackStar() {
		return feedbackStar;
	}

	public void setFeedbackStar(int feedbackStar) {
		this.feedbackStar = feedbackStar;
	}
}
