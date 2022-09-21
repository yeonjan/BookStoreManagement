package model.service;

import java.sql.SQLException;
import java.util.List;

import dto.Book;
import model.dao.BookDao;

public class BookService {
	// 싱글톤
	public BookService() {
	}

	private static BookService instance = new BookService();

	public static BookService getInstance() {
		return instance;
	}

	BookDao bookDao = BookDao.getInstance();

	// isbn에 맞는 도서 찾기
	public Book getBookByIsbn(String isbn) throws SQLException {
		return bookDao.getBookByIsbn(isbn);

	}

	// 도서 등록
	public int registBook(Book book) throws SQLException {
		return bookDao.insertBook(book);

	}

	// 도서 목록 조회
	public List<Book> getBookList() throws SQLException {
		return bookDao.selectBookList();
	}
}
