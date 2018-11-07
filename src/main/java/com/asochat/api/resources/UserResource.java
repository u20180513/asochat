package com.asochat.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asochat.action.LoginAction;
import com.asochat.model.Student;

@Path("user")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Student login() { // テスト用
		LoginAction action = new LoginAction();
		Student login_student = new Student(11, 1111111, "テスト太郎");
		Student result = action.execute(login_student);
		return result;
	}

	@POST
	@Path("/user/{id}/{password}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student get(
			@PathParam("id") int id,
			@PathParam("password") String name
			) {
		// 引数からStudentオブジェクト取得
		Student student = new Student(0, id, name);

		return student;
	}

}
