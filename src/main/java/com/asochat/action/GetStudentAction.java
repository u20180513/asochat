package com.asochat.action;

import java.util.ArrayList;
import java.util.List;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCStudentDAO;
import com.asochat.model.Student;

public class GetStudentAction {
	public static List<Student> execute() {
		final JDBCStudentDAO dao = DAOFactory.createASOStudentDAOInstance();
		List<Student> studentList = new ArrayList<Student>();
		Student test = new Student();
		studentList.add(test);
		studentList.add(test);

		return studentList;
	}
}
