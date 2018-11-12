package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCEventDAO;

public class UpdateEventAction {
	public void execute(int eventId) {
		final JDBCEventDAO dao = DAOFactory.createJDBCEventDAO();

		dao.update(eventId);
	}
}
