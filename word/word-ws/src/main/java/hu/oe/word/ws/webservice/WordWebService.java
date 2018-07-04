package hu.oe.word.ws.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.bind.annotation.XmlElement;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.error.ApplicationError;
import hu.oe.word.ejbservice.facade.DictionariesFacade;
import hu.oe.word.ejbservice.facade.TranslationFacade;
import hu.oe.word.ejbservice.stub.DictionaryStub;
import hu.oe.word.ejbservice.stub.TranslationStub;

@WebService(name = "Word", serviceName = "WordService" , targetNamespace = "http://www.word.hu/Word")
@SOAPBinding(style=Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class WordWebService {

	@EJB
	private DictionariesFacade dictionariesFacade;
	
	@EJB
	private TranslationFacade translationFacade;
	
	@WebMethod(action = "http://www.word.hu/Word/getDictionaries", operationName = "GetDictionaries")
	@WebResult(name = "Dictionary")
	public List<DictionaryStub> getDictionaries(){
		return dictionariesFacade.getAllDictionray();
	}
	
	@WebMethod(action = "http://www.word.hu/Word/getTranslationsForDictionary", operationName = "GetTranslationsForDictionary")
	@WebResult(name = "Translation")
	public List<TranslationStub> getTranslationsForDictionary(@XmlElement(name = "dictionaryId", required = true) Long dictionaryId) throws AdaptorException {
		try{
			return translationFacade.getAllTranslationByDictionaryId(dictionaryId);
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
	}
	
	@WebMethod(action = "http://www.word.hu/Word/newDictionary", operationName = "newDictionary")
	@WebResult(name = "NewDictionary")
	public void newDictionary(@XmlElement(name = "name", required = true) String name, @XmlElement(name = "type", required = true) String type) throws AdaptorException {
		try{
			dictionariesFacade.saveNewDictionary(name, type);
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
	}
	
	@WebMethod(action = "http://www.word.hu/Word/errorTest", operationName = "ErrorTest")
	@WebResult(name = "ErrorTest")
	public void errorTest() throws AdaptorException {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
	}
}
