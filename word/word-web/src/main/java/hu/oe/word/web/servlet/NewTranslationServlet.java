package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.oe.word.ejbservice.facade.TranslationFacade;

@WebServlet("/newtranslation")
public class NewTranslationServlet extends HttpServlet {

	private static final long serialVersionUID = -3632126370557330813L;
	
	@EJB
	private TranslationFacade translationFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setAttribute("dictionaryid", req.getParameter("dictionaryid"));
		getServletContext().getRequestDispatcher("/resources/pages/newTranslation.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		translationFacade.saveNewTranslation(Long.valueOf(req.getParameter("dictionaryid")), req.getParameter("from"), req.getParameter("to"));
		resp.sendRedirect("translationPage?dictionaryid="+req.getParameter("dictionaryid"));
	}
}
