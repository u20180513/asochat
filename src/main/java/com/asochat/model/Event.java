package com.asochat.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class Event {
	private int id;
	private String title;
	private String img_path;
	private String description;
	private int max_user;
	private String date;
	private int flg;

	public Event() {
	}
}
