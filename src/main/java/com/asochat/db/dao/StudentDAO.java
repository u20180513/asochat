package com.asochat.db.dao;

import java.util.List;

import com.asochat.model.Student;

public interface StudentDAO {

	public void insert(Student student);

	public void delete(Student student);

	public void update(Student student);

	public List<Student> getList();
}
