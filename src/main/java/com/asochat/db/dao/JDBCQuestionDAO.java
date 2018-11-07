package com.asochat.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.asochat.model.Anser;
import com.asochat.model.Question;

public class JDBCQuestionDAO implements QuestionDAO{
	DataSource source;

	public JDBCQuestionDAO(DataSource source) {
		this.source = source;
	}

	public void insert(Question question) {
		try {
			String sql = "INSERT INTO Question "
								+ "VALUES(?, ?, ?, ?);";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, question.getId());
			statement.setInt(2, question.getUser().getId());
			statement.setString(3, question.getTitle());
			statement.setString(4, question.getContent());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Question question) {
		try {
			String sql = "DELETE FROM Question "
								+ "WHERE question_id = ?;";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, question.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_ans(Anser ans) {
		try {
			String sql = "INSERT INTO Anser "
								+ "VALUES(?, ?, ?, ?, ?);";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, ans.getId());
			statement.setInt(2, ans.getQuestion().getId());
			statement.setInt(3, ans.getStudent().getId());
			statement.setString(4, ans.getTitle());
			statement.setString(5, ans.getContent());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public List<Question> getList() {
		List<Question> list = new ArrayList<Question>();

		try {
			String sql = "SELECT * FROM Question ;";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Question q = new Question();
				q.setId(rs.getInt("question_id"));
				q.setTitle(rs.getString("question_title"));
				q.setContent(rs.getString("question_content"));
				list.add(q);
			}

			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}


}
