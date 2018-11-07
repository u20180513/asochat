package com.asochat.db.dao;

import java.util.List;

import com.asochat.model.Anser;
import com.asochat.model.Question;

public interface QuestionDAO {

	public void insert(Question question);

	public void delete(Question question);

	public void insert_ans(Anser ans);

	public List<Question> getList();
}
