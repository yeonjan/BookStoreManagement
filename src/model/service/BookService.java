package model.service;

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

	// 도서 목록 조회
	public List<Book> getBookList() {
		return bookDao.selectBookList();
	}

}
