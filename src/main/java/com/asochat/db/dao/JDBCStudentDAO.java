package com.asochat.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.asochat.model.Student;

public class JDBCStudentDAO implements StudentDAO {
	DataSource source;

	public JDBCStudentDAO(DataSource source) {
		this.source = source;
	}

	public void insert(Student student) {
		try {
			String sql = "INSERT INTO Event()"
								+ "VALUES(?,?,?);";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, student.getId());
			statement.setInt(2, student.getNum());
			statement.setString(3, student.getName());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void delete(Student student) {
		try {
			String sql = "DELETE FROM Student "
								+ "WHERE asost_id = ?;";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, student.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void update(Student student) {
		try {
			String sql = "UPDATE Student "
								+ "SET asost_name = ? "
								+ "WHERE asost_id = ?;";

			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public List<Student> getList() {
		List<Student> list = new ArrayList<Student>();

		try {
			String sql = "SELECT * FROM Event "
								+ "WHERE auth_flg = 1;";
			Connection connection = source.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while(rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("asost_name"));
				student.setNum(rs.getInt("asost_num"));
				list.add(student);
			}

			return list;
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return null;
	}


}
