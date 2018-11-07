package com.asochat.db;

import java.util.Set;

public interface ASOStudentBase {
	public void insert();
	public void update();
	public void delete(int id);

	public Set<ASOStudentBase> list();

}
