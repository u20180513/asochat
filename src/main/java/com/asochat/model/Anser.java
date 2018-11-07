package com.asochat.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class Anser {
	private int id;
	private String title;
	private String content;

	private Question question;
	private Student student;

	public Anser() {
	}
}
