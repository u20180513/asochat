package com.asochat.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.asochat.model.Room;

public class JDBCOpenRoomDAO implements OpenRoomDAO{
	DataSource source;

	public JDBCOpenRoomDAO(DataSource source) {
		this.source = source;
	}

	public List<Room> getList() {
		List<Room> list = new ArrayList<Room>();

		try {
			String sql = "SELECT * FROM OpenRoom ;";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Room room = new Room();
				room.setId(rs.getInt("oroom_id"));
				room.setName(rs.getString("oroom_name"));
				list.add(room);
			}

			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}

	public void insert_participant(int oroomId, int asostId) {
		try {
			String sql = "INSERT INTO ORParticipant "
								+ "VALUES(?, ?)";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, oroomId);
			statement.setInt(2, asostId);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert_message(int oroomId, int asostId, String message) {
		try {
			String sql = "INSERT INTO ORMessage "
								+ "VALUES(?, ?, ?, ?)";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, oroomId);
			statement.setInt(2, asostId);
			statement.setString(3, message);
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ii:ss");
			statement.setString(4, sdf.format(now));
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
