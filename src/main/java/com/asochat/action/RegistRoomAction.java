package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCPrivateRoomDAO;
import com.asochat.model.Room;

public class RegistRoomAction {
	public void execute(Room room) {
		final JDBCPrivateRoomDAO dao = DAOFactory.createPrivateRoomDAO();

		dao.insert(room);
	}
}
