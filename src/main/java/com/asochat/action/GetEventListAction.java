package com.asochat.action;

import java.util.ArrayList;
import java.util.List;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCEventDAO;
import com.asochat.model.Event;

public class GetEventListAction {
	public List<Event> execute() {
		final JDBCEventDAO dao = DAOFactory.createJDBCEventDAO();
		List<Event> eventList = new ArrayList<Event>();
		Event e = new Event(11, "勉強会", "", "勉強は建前だよ、遊ぶよ", 1, "", 0);
		eventList.add(e);

		return eventList;
	}
}
