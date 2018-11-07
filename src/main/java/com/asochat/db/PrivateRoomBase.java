package com.asochat.db;

import java.time.LocalDate;

import com.asochat.model.Room;
import com.asochat.model.Student;

public interface PrivateRoomBase {
	public void insert();
	public void update(int id);
	public void delete(int id);

	public void auth(Room room, String passphrase);
	public void participant(Room room, Student student);

	public void message(int id, Student student, String msg, LocalDate date);
}
