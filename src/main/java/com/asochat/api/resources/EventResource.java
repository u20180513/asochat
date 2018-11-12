package com.asochat.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asochat.action.DeleteEventAction;
import com.asochat.action.GetEventListAction;
import com.asochat.action.RegistApplicantAction;
import com.asochat.action.RegistEventAction;
import com.asochat.action.UpdateEventAction;
import com.asochat.model.Event;

@Path("/event")
public class EventResource {

	private static List<Event> events;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Event> all() {
		GetEventListAction action = new GetEventListAction();
		events = action.execute();
		return events;
	}

	@POST
	@Path("{id}/{name}/{descript}/{max_user}/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	public void post(
			@PathParam("id") String id,
			@PathParam("name") String name,
			@PathParam("descript") String descript,
			@PathParam("max_user") String max_user,
			@PathParam("date") String date
			) {
		Event event = new Event(8, "", "", "", 9, "", 0);
		final RegistEventAction action = new RegistEventAction();
		action.execute(event);
	}

	@POST
	@Path("{ room_id}/{user_id }")
	@Produces(MediaType.APPLICATION_JSON)
	public void join(
			@PathParam("room_id") int room_id,
			@PathParam("user_id") int user_id
			) {
		final RegistApplicantAction action = new RegistApplicantAction();
		action.execute(room_id, user_id, "event");
	}

	@POST
	@Path("/regist/{event_id}/")
	public void regist(
			@PathParam("event_id") int id
			) {
		final UpdateEventAction action = new UpdateEventAction();
		action.execute(id);
	}

	@POST
	@Path("/delete/{event_id}/")
	public void delete(
			@PathParam("event_id") int id
			) {
		final DeleteEventAction action = new DeleteEventAction();
		action.execute(id);
	}
}
