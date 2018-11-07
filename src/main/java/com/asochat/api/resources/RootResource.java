package com.asochat.api.resources;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class RootResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> get() {
		Map<String, String> map = new HashMap<>();
		map.put("root", "/api/");
		map.put("", "/user");
		map.put("", "");
		map.put("", "");

		return map;
	}
}
