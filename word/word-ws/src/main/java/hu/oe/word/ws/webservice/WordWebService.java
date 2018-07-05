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
	
	//--Dictionary methods--
	@WebMethod(action = "http://www.word.hu/Word/getDictionaries", operationName = "GetDictionaries")
	@WebResult(name = "Dictionary")
	public List<DictionaryStub> getDictionaries(){
		return dictionariesFacade.getAllDictionray();
	}
	
	@WebMethod(action = "http://www.word.hu/Word/newDictionary", operationName = "NewDictionary")
	@WebResult(name = "NewDictionary")
	public @XmlElement(name = "created", required = true) boolean newDictionary(@XmlElement(name = "name", required = true) String name, @XmlElement(name = "type", required = true) String type) throws AdaptorException {
		try{
			dictionariesFacade.saveNewDictionary(name, type);
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
		return true;
	}
	
	@WebMethod(action = "http://www.word.hu/Word/deleteDictionary", operationName = "DeleteDictionary")
	@WebResult(name = "DeleteDictionary")
	public @XmlElement(name = "deleted", required = true) boolean deleteDictionary(@XmlElement(name = "id", required = true) String id) throws AdaptorException {
		if (id!=null) {
			dictionariesFacade.removeDictionary(Long.valueOf(id));
		}
		return true;
	}
	
	//--Translation methods--
	@WebMethod(action = "http://www.word.hu/Word/getTranslationsForDictionary", operationName = "GetTranslationsForDictionary")
	@WebResult(name = "Translation")
	public List<TranslationStub> getTranslationsForDictionary(@XmlElement(name = "dictionaryId", required = true) Long dictionaryId) throws AdaptorException {
		try{
			return translationFacade.getAllTranslationByDictionaryId(dictionaryId);
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
	}
	
	@WebMethod(action = "http://www.word.hu/Word/newTranslation", operationName = "NewTranslation")
	@WebResult(name = "NewTranslation")
	public @XmlElement(name = "created", required = true) boolean newTranslation(@XmlElement(name = "dictionaryid", required = true) Long dictionaryid, @XmlElement(name = "from", required = true) String from, @XmlElement(name = "to", required = true) String to) throws AdaptorException {
		try{
			translationFacade.saveNewTranslation(dictionaryid, from, to);
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
		return true;
	}
	
	@WebMethod(action = "http://www.word.hu/Word/deleteTranslation", operationName = "DeleteTranslation")
	@WebResult(name = "DeleteTranslation")
	public @XmlElement(name = "deleted", required = true) boolean deleteTranslation(@XmlElement(name = "id", required = true) Long id) throws AdaptorException {
		translationFacade.removeTranslation(id);
		return true;
	}

	@WebMethod(action = "http://www.word.hu/Word/editTranslation", operationName = "EditTranslation")
	@WebResult(name = "EditTranslation")
	public @XmlElement(name = "edited", required = true) boolean editTranslation(@XmlElement(name = "id", required = true) Long id, @XmlElement(name = "from", required = true) String from, @XmlElement(name = "to", required = true) String to) throws AdaptorException {
		translationFacade.editTranslation(id, from, to);
		return true;
	}
	
	//--Test methods--
	@WebMethod(action = "http://www.word.hu/Word/errorTest", operationName = "ErrorTest")
	@WebResult(name = "ErrorTest")
	public void errorTest() throws AdaptorException {
		throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
	}
}
