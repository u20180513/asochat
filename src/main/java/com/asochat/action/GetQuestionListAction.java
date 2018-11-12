package com.asochat.action;

import java.util.ArrayList;
import java.util.List;

import com.asochat.db.dao.DAOFactory;
import com.asochat.db.dao.JDBCOpenRoomDAO;
import com.asochat.model.Question;

public class GetQuestionListAction {
	public static final List<Question> execute() {
		final JDBCOpenRoomDAO dao = DAOFactory.createOpenRoomDAO();
		final List<Question> qs = new ArrayList<Question>();
		Question q = new Question(9, 8, "プロジェクトはいつ終わる？", "知らん");
		qs.add(q);
		qs.add(q);

		return qs;
	}
}
