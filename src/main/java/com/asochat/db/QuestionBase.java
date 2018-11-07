package com.asochat.db;

import com.asochat.model.Question;

public interface QuestionBase {
	public void insert(Question question);
	public void update(Question question, int id);
	public void delete(int id);

}
