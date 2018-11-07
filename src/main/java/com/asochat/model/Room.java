package com.asochat.model;

import javax.ws.rs.FormParam;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class Room {

	@FormParam("integer")
	private int id;
	// private Student creator;
	@FormParam("integer")
	private int creatorId;
	@FormParam("string")
	private String name;
	@FormParam("string")
	private String description;

	public Room() {
	}
}
