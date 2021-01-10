package com.yby.demo.domain;

import java.sql.Timestamp;

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
@Table(name = "result")
public class QuizResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RESULT_ID")
	private int resultId;
	
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "TYPE_ID")
	private int typeId;
	@Column(name = "SCORE")
	private int score;
	@Column(name = "START_TIME")
	private Timestamp startTime;
	@Column(name = "END_TIME")
	private Timestamp endTime;
	
	
	@ManyToOne(fetch = FetchType.EAGER )
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false,updatable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE_ID", nullable = false, insertable = false,updatable = false)
	private QuizType type;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public QuizType getType() {
		return type;
	}
	public void setType(QuizType type) {
		this.type = type;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	@Override
	public String toString() {
		return "QuizResult [resultId=" + resultId + ", userId=" + userId + ", typeId=" + typeId + ", score=" + score
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
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
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
