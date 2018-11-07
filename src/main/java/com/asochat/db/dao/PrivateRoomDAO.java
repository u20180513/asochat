package com.asochat.db.dao;

import java.util.List;

import com.asochat.model.Room;

public interface PrivateRoomDAO {

	public void insert(Room room);

	public void delete(Room room);

	public void insert_participant(int oroomId, int asostId);

	public void insert_pass(Room room, String pass);

	public void insert_message(int proomId, int asostId, String message);

	public List<Room> getList();
}
