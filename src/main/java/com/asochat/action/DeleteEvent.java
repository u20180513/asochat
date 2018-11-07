package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCEventDAO;
import com.asochat.model.Event;

public class DeleteEvent {
	public void execute(Event event) {
		final JDBCEventDAO dao = DAOFactory.createJDBCEventDAO();

		dao.delete(event);
	}
}
