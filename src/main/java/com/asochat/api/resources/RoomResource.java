package com.asochat.api.resources;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asochat.action.GetRoomListAction;
import com.asochat.action.RegistApplicantAction;
import com.asochat.action.RegistRoomAction;
import com.asochat.model.Room;

@Path("/room")
public class RoomResource{

	private static List<Room> rooms;

	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Room> all() {
		rooms = GetRoomListAction.execute("all");
		return rooms;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Room> getPrivateRoomList() {
		rooms = GetRoomListAction.execute("private");
		return rooms;
	}

	@POST
	@Path("{room_id}/{user_id}/{name}/{descript}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public void create(
			@PathParam("room_id") int room_id,
			@PathParam("user_id") int user_id,
			@PathParam("name") String name,
			@PathParam("descript") String descript,
			@PathParam("password") String password
			) {
		final RegistRoomAction action = new RegistRoomAction();
		final Room room = new Room(room_id, user_id, name, descript, password);
		action.execute(room);
	}

	@POST
	@Path("{room_id}/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void join_private(
			@PathParam("room_id") int room_id,
			@PathParam("user_id") int user_id
			) {
		final RegistApplicantAction action = new RegistApplicantAction();
		action.execute(room_id, user_id, "private");
	}

	/*
	 * 以下、メソッドはOpen Room用。
	 */
	@GET
	@Path("/open")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Room> getOpenRoomList() {
		rooms = GetRoomListAction.execute("open");
		return rooms;
	}

	@POST
	@Path("/open/{room_id}/{user_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void join_open(
			@PathParam("room_id") int room_id,
			@PathParam("user_id") int user_id
			) {
		final RegistApplicantAction action = new RegistApplicantAction();
		action.execute(room_id, user_id, "open");
	}

	@POST
	@Path("/open/{room_id}/{user_id}/{message}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public void send_open(
			@PathParam("room_id") int room_id,
			@PathParam("user_id") int user_id,
			@PathParam("message") String message,
			@PathParam("date") String date
			) {
	}

}
