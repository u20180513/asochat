package com.asochat.action;

import java.util.ArrayList;
import java.util.List;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCOpenRoomDAO;
import com.asochat.model.Room;

public class GetRoomListAction {
	public static final List<Room> execute() {
		final JDBCOpenRoomDAO dao = DAOFactory.createOpenRoomDAO();
		final List<Room> rooms = new ArrayList<Room>();
		Room room = new Room(11, 22, "Room name", "desc");
		rooms.add(room);
		rooms.add(room);

		return rooms;
	}
}
