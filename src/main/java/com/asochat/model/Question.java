package com.asochat.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class Question {
	private int id;
	// private Student user;
	private int studentId;
	private String title;
	private String content;

	public Question() {
	}
}