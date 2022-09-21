package controller;

import java.io.IOException;
import java.sql.SQLException;
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
				try {
					getBookList(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "goRegist":
				request.getRequestDispatcher("/Book/BookRegist.jsp").forward(request, response);
				break;
			case "regist":
				try {
					registBook(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}

		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// 도서 등록
	private void registBook(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("registBook 요청 확인");

		Book book = new Book();
		book.setIsbn(request.getParameter("isbn"));
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));

		bookService.registBook(book);
		try {
			response.sendRedirect(request.getContextPath() + "/book?action=list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 도서 리스트 조회
	private void getBookList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		List<Book> bookList = bookService.getBookList();

		request.setAttribute("list", bookList);
		request.getRequestDispatcher("/Book/BookList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
