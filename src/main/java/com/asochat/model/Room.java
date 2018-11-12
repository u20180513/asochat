package com.asochat.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class Room {
	private int id;
	// private Student creator;
	private int creatorId;
	private String name;
	private String description;
	private String password;

	public Room() {
	}
}
