package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.facade.TranslationFacade;

@WebServlet("/edittranslation")
public class EditTranslationServlet extends HttpServlet {

	private static final long serialVersionUID = -3632126370557330813L;
	
	@EJB
	private TranslationFacade translationFacade;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setAttribute("dictionaryid", req.getParameter("dictionaryid"));
		req.setAttribute("id", req.getParameter("id"));
		req.setAttribute("translation", translationFacade.getTranslationById(Long.valueOf(req.getParameter("id"))));
		getServletContext().getRequestDispatcher("/resources/pages/editTranslation.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		try {
			translationFacade.editTranslation(Long.valueOf(req.getParameter("id")), req.getParameter("from"), req.getParameter("to"));
		} catch (AdaptorException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("translationPage?dictionaryid="+req.getParameter("dictionaryid"));
	}
}
