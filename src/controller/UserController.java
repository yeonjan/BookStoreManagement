package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import dto.User;
import model.service.UserService;

@WebServlet("/user")
public class UserController extends HttpServlet {
	UserService userService = UserService.getInstance();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null)
			response.sendRedirect("");
		else {
			try {
				switch (action) {
				case "goLogin":
					request.getRequestDispatcher("/User/LoginForm.jsp").forward(request, response);
					break;
				case "login":
					login(request, response);
					break;
				case "logout":
					logout(request, response);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//로그아웃
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		response.sendRedirect(request.getContextPath());
		
	}

	// 로그인
	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");

		User user = new User();
		user.setId(id);
		user.setPwd(pwd);

		boolean isFind = userService.login(user);

		if (isFind) {
			// 1) 세션객체 반환
			HttpSession session = request.getSession(); // 세션 객체 없으면 만들어서 반환
			// 2) 세션에 정보 저장
			session.setAttribute("userInfo", user);

			// 2-3. 아이디 저장하기 체크
			// 1) 쿠키 생성
			Cookie cookie = new Cookie("savedId", id);
			// 2) 쿠키 옵션 설정
			cookie.setPath(request.getContextPath());

			if (remember != null)
				cookie.setMaxAge(60 * 60 * 24); // 아이디 저장 O
			else
				cookie.setMaxAge(0); // 아이디 저장 X

			// 3) response에 추가
			response.addCookie(cookie);
		}
		response.sendRedirect(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
