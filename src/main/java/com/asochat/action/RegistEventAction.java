package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCEventDAO;
import com.asochat.model.Event;

public class RegistEventAction {
	public void execute(Event event) {
		final JDBCEventDAO dao = DAOFactory.createJDBCEventDAO();

		dao.insert(event);

	}
}
