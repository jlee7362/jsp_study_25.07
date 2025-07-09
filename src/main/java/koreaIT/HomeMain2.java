package koreaIT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeMain2")
public class HomeMain2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append("Served at:hello ").append(request.getContextPath());
		response.getWriter().append("<br><a href=\"http://localhost:8080/jlee_servlet/HomeManinServlet\" target=\"_blank\">Home으로 가기</a>");
	}

}
