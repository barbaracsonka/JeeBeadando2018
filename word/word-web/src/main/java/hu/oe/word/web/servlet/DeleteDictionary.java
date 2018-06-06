package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.facade.DictionariesFacade;

@WebServlet("/deleteDictionary")
public class DeleteDictionary extends HttpServlet {

	private static final long serialVersionUID = -3632126370557330813L;
	
	@EJB
	private DictionariesFacade dictionariesFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id!=null) {
			try {
				dictionariesFacade.removeDictionary(Long.valueOf(id));
			}
				catch (AdaptorException e) {
				e.printStackTrace();
			}
		}
		
		resp.sendRedirect("index");
	}
}
