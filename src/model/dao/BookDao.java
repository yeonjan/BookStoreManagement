package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

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

	// isbn에 맞는 도서 찾기
	public Book getBookByIsbn(String isbn) throws SQLException {
		String sql = "select * from book where isbn=" + isbn;

		Book findBook = new Book();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				findBook.setIsbn(rs.getString(1));
				findBook.setTitle(rs.getString(2));
				findBook.setAuthor(rs.getString(3));
				findBook.setPrice(Integer.parseInt(rs.getString(4)));
				findBook.setDescription(rs.getString(5));
				findBook.setImg(rs.getString(6));

			}
			return findBook;

		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
	}

	// 도서 정보 등록
	public int insertBook(Book book) throws SQLException {
		System.out.println(book);
		String sql = "insert into book (isbn,title,author,price) values (?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setInt(4, book.getPrice());

			int cnt = pstmt.executeUpdate();
			return cnt;

		} finally {
			dbUtil.close(pstmt, conn);
		}

	}

	// 도서 목록 조회
	public List<Book> selectBookList() throws SQLException {

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

			return bookList;

		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

	}

}
