package com.asochat.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.asochat.model.Event;

public class JDBCEventDAO implements EventDAO{
	DataSource source;

	public JDBCEventDAO(DataSource source) {
		this.source = source;
	}

	public void insert(Event event) {
		try {
			String sql = "INSERT INTO Event()"
							+ "VALUES(?,?,?,?,?,?,?);";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, event.getId());
			statement.setString(2, event.getTitle());
			statement.setString(3, event.getImg_path());
			statement.setString(4, event.getDescription());
			statement.setInt(5, event.getMax_user());
			statement.setString(6, event.getDate());
			statement.setInt(7, event.getFlg());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void delete(int eventId) {
		try {
			String sql = "DELETE FROM Event "
								+ "WHERE event_id = ?";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, eventId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Event> getList() {
		List<Event> list = new ArrayList<Event>();

		try {
			String sql = "SELECT * FROM Event "
								+ "WHERE auth_flg = 1;";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Event event = new Event();
				event.setTitle(rs.getString("event_name"));
				event.setDescription(rs.getString("event_description"));
				event.setMax_user(rs.getInt("event_max_user"));
				event.setDate(rs.getString("event_date"));
				list.add(event);
			}

			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}

	public void update(int eventId) {
		try {
			String sql = "UPDATE Event "
								+ "SET auth_flg = 1 "
								+ "WHERE event_id = ?;";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, eventId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_participant(int eventId, int asostId) {
		try {
			String sql = "INSERT INTO EventParticipant "
								+ "VALUES(?, ?)";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, eventId);
			statement.setInt(2, asostId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
