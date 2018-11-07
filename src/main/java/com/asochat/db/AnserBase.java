package com.asochat.db;

import com.asochat.model.Anser;
import com.asochat.model.Question;

public interface AnserBase {
	public void insert(Question question, Anser ans);
}
