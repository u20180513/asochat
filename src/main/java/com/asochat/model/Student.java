package com.asochat.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JacksonXmlRootElement
public class Student {
	private int id;
	private int num;
	private String name;

	public Student() {
	}
	public Student( int num, String name) {
		this.setNum(num);
		this.setName(name);
	}
}
