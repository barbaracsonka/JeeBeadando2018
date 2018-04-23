package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newbook")
public class NewBookServlet extends HttpServlet {

	private static final long serialVersionUID = -3632126370557330813L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		getServletContext().getRequestDispatcher("/resources/pages/newBook.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		//Todo save
		getServletContext().getRequestDispatcher("/resources/pages/index.jsp").forward(req,resp);
	}
}
