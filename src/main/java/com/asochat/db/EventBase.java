package com.asochat.db;

import java.util.Set;

import com.asochat.model.Event;
import com.asochat.model.Student;

public interface EventBase {
	public void insert(Event event);
	public void update(Event event, int id);
	public void delete(int id);

	public Set<Event> list();
	public void participant(Event event, Student student);
}
