package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.oe.word.ejbservice.facade.DictionariesFacade;

@WebServlet("/index")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = -8347117100779983559L;

	@EJB
	private DictionariesFacade dictionariesFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");		
		req.setAttribute("Dictionaries", dictionariesFacade.getAllDictionray());

		getServletContext().getRequestDispatcher("/resources/pages/index.jsp").forward(req,resp);
	}
}
