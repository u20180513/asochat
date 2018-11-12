package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCEventDAO;

public class DeleteEventAction {
	public void execute(int eventId) {
		final JDBCEventDAO dao = DAOFactory.createJDBCEventDAO();

		dao.delete(eventId);
	}
}
