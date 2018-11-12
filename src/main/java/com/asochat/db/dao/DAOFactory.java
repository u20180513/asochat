package com.asochat.db.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOFactory {
	public static JDBCStudentDAO createASOStudentDAOInstance(){
		return new JDBCStudentDAO(getDataSource());
	}

	public static JDBCEventDAO createJDBCEventDAO() {
		return new JDBCEventDAO(getDataSource());
	}

	public static JDBCPrivateRoomDAO createPrivateRoomDAO() {
		return new JDBCPrivateRoomDAO(getDataSource());
	}

	public static JDBCOpenRoomDAO createOpenRoomDAO() {
		return new JDBCOpenRoomDAO(getDataSource());
	}

	public static JDBCQuestionDAO createQuestionDAO(){
		return new JDBCQuestionDAO(getDataSource());
	}
	/**
	 * <p>指定DBから、DataSourceオブジェクトを取得するための静的メソッドです。
	 * </p>
	 *
	 * @return DataSource
	 *
	 * @exception NamingException
	 */
	private static DataSource getDataSource() {
		InitialContext initCon = null;
		DataSource ds = null;
		final String DB_NAME = "asochat";

		try {
			initCon = new InitialContext();
			ds = (DataSource)initCon.lookup("java:comp/env/jdbc/" + DB_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
			if (initCon != null) {
				try {
					initCon.close();
				} catch (NamingException ex) {
					ex.printStackTrace();
					//throw new DataAccessException();
				}
			}
			//throw new DataAccessException();
		}
		return ds;
	}
}
