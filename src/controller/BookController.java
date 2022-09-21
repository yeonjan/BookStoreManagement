package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Book;
import model.service.BookService;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = BookService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			response.sendRedirect("");
		else {
			switch (action) {
			case "list":
				getBookList(request, response);
				break;

			default:
				break;
			}

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// 도서 리스트 조회
	private void getBookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Book> bookList = bookService.getBookList();
		
		request.setAttribute("list", bookList);
		request.getRequestDispatcher("/Book/BookList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
