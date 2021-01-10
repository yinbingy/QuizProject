package com.yby.demo.dao;

import java.util.List;

import com.yby.demo.domain.QuizDetail;

public interface QuizDetailDAO {
	public List<QuizDetail> selectQuizDetailByResultId(int i);
	
	public boolean addQuizDetail(QuizDetail qd);
}
