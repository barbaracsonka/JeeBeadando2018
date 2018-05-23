package hu.oe.word.web.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.oe.word.ejbservice.facade.TranslationFacade;

@WebServlet("/translationPage")
public class TranslationPageServlet extends HttpServlet {
	private static final long serialVersionUID = -8347117100779983559L;

	@EJB
	private TranslationFacade translationFacade;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String dictionaryId = req.getParameter("dictionaryid");
		req.setAttribute("dictionaryId", dictionaryId);
		req.setAttribute("translations", translationFacade.getAllTranslationByDictionaryId(Long.valueOf(dictionaryId)));

		getServletContext().getRequestDispatcher("/resources/pages/translationPage.jsp").forward(req,resp);
	}
}
