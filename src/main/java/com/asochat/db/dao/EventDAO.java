package com.asochat.db.dao;

import java.util.List;

import com.asochat.model.Event;

public interface EventDAO{

	public List<Event> getList();

	public void insert(Event event);

	public void delete(int eventId);

	public void update(int eventId);

	public void insert_participant(int eventId, int asostId);
}