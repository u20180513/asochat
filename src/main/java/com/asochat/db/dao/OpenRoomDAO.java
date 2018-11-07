package com.asochat.db.dao;

import java.util.List;

import com.asochat.model.Room;

public interface OpenRoomDAO {
	public List<Room> getList();

	public void insert_participant(int oroomId, int asostId);

	public void insert_message(int oroomId, int asostId, String message);
}
