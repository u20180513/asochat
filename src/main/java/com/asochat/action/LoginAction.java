package com.asochat.action;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCStudentDAO;
import com.asochat.model.Student;

public class LoginAction {
	public Student execute(Student login_student) {
		final JDBCStudentDAO dao = DAOFactory.createASOStudentDAOInstance();
		// login_student
		final Student student = login_student;

		return student;
	}
}
