package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;
import util.DBUtil;

public class UserDao {
	private UserDao() {

	}

	private static UserDao instance = new UserDao();

	public static UserDao getInstance() {
		return instance;
	}

	DBUtil dbUtil = DBUtil.getInstance();

	public int saveUser(User user) {

		return 0;
	}

	// 해당하는 유저가 있는지
	public boolean findUser(User user) throws SQLException {

		String sql = "select * from user where id=? and pwd=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			rs = pstmt.executeQuery();

			if (rs == null) {
				return false;
			} else {
				return true;
			}

		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

	}

}
