package com.asochat.action;

import java.util.List;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCEventDAO;
import com.asochat.model.Event;

public class GetEventListAction {
	public List<Event> execute() {
		final JDBCEventDAO dao = DAOFactory.createJDBCEventDAO();

		List<Event> eventList = dao.getList();

		return eventList;
	}
}
