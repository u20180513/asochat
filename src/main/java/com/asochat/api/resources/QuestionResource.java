package com.asochat.api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.asochat.action.GetQuestionListAction;
import com.asochat.action.RegistAnserAction;
import com.asochat.action.RegistQuestionAction;
import com.asochat.model.Anser;
import com.asochat.model.Question;

@Path("/question")
public class QuestionResource {
	private static List<Question> questions;

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Question> all() {
		questions = GetQuestionListAction.execute();
		return questions;
	}

	@POST
	@Path("{ user_id}/{title}/{content}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Question> post(
			@PathParam("user_id") int id,
			@PathParam("title") String title,
			@PathParam("content") String content
			) {
		Question q = new Question();
		// 登録処理
		RegistQuestionAction action = new RegistQuestionAction();
		action.execute(q);

		List<Question> after = questions;
		after.add(q);
		questions = after;

		return questions;
	}

	@POST
	@Path("{question_id}/{user_id}/{title}/{content}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> replay(
			@PathParam("question_id") int question_id,
			@PathParam("user_id") int user_id,
			@PathParam("title") String title,
			@PathParam("content") String content
			) {
		Anser anser = new Anser();
		RegistAnserAction action = new RegistAnserAction();
		action.execute(anser);

		return questions;
	}
}
