package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dto.Book;
import util.DBUtil;

public class BookDao {

	private BookDao() {

	}

	private static BookDao instance = new BookDao();

	public static BookDao getInstance() {
		return instance;
	}

	DBUtil dbUtil = DBUtil.getInstance();

	// 책목록 조회
	public List<Book> selectBookList() {

		String sql = "select isbn,title,author,price from book";

		List<Book> bookList = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setIsbn(rs.getString(1));
				book.setTitle(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(Integer.parseInt(rs.getString(4)));

				bookList.add(book);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;

	}

}
