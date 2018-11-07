package com.asochat.db;

import com.asochat.model.Room;

public interface OpenRoomBase {
	public void insert(Room room);
	public void update(Room room, int id);
	public void delete(int id);
}
