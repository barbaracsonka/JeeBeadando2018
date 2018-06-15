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

import hu.oe.word.ejbservice.facade.DictionariesFacade;
import hu.oe.word.ejbservice.stub.DictionaryStub;

@WebService(name = "Word", serviceName = "WordService" , targetNamespace = "http://www.word.hu/Word")
@SOAPBinding(style=Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class WordWebService {

	@EJB
	private DictionariesFacade dictionariesFacade;
	
	
	@WebMethod(action = "http://www.word.hu/Word/getDictionaries", operationName = "GetDictionaries")
	@WebResult(name = "Dictionary")
	public List<DictionaryStub> getDictionaries(){
		return dictionariesFacade.getAllDictionray();
	}
}
