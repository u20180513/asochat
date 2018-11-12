package com.asochat.api.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asochat.action.GetStudentAction;
import com.asochat.action.LoginAction;
import com.asochat.model.Student;

@Path("/user")
public class UserResource {

	private static List<Student> students;

	@GET
	@Path("/all")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Student> all() {
		students = GetStudentAction.execute();
		return students;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student login() { // テスト用
		LoginAction action = new LoginAction();
		Student login_student = new Student(11, 1111111, "テスト太郎");
		Student result = action.execute(login_student);
		return result;
	}

	@POST
	@Path("{id}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student login(
			@PathParam("id") int id,
			@PathParam("password") String pass
			) {
		LoginAction action = new LoginAction();
		Student login_student = new Student(0, id, pass);
		Student result = action.execute(login_student);

		return result;
	}


}
