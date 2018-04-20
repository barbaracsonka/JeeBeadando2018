package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

@WebServlet("/index")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = -8347117100779983559L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		//resp.getWriter().println("Hello");
		getServletContext().getRequestDispatcher("/resources/pages/index.jsp").forward(req,resp);
	}
}
