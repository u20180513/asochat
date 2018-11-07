package com.asochat.api.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asochat.action.GetRoomListAction;
import com.asochat.model.Room;

@Path("/room")
public class RoomResource{

	private static List<Room> rooms;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Room> all() {
		rooms = GetRoomListAction.execute();
		return rooms;
	}

	@GET
	@Path("/open")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> getOpenRoomList() {
		rooms = GetRoomListAction.execute();
		return rooms;
	}
}
