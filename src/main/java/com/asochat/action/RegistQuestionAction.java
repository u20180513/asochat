package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCQuestionDAO;
import com.asochat.model.Question;

public class RegistQuestionAction {
	public void execute(Question question) {
		final JDBCQuestionDAO dao = DAOFactory.createQuestionDAO();
		// dao.insert(question);

		return;
	}
}
