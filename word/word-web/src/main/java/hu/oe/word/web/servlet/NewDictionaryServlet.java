package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.oe.word.ejbservice.facade.*;

@WebServlet("/newdictionary")
public class NewDictionaryServlet extends HttpServlet {

	private static final long serialVersionUID = -3632126370557330813L;
	
	@EJB
	private DictionariesFacade dictionariesFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		getServletContext().getRequestDispatcher("/resources/pages/newDictionary.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		dictionariesFacade.saveNewDictionary(req.getParameter("name"), req.getParameter("type"));
		
		getServletContext().getRequestDispatcher("/resources/pages/index.jsp").forward(req,resp);
	}
}
