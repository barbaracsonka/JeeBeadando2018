package hu.oe.word.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.error.ApplicationError;
import hu.oe.word.ejbservice.facade.DictionariesFacade;
import hu.oe.word.ejbservice.stub.DictionaryStub;

@Stateless
public class DictionaryRestServiceImpl implements DictionrayRestService {

	@EJB
	private DictionariesFacade dictionariesFacade;
	
	@Override
	public List<DictionaryStub> getAllDictionary() throws AdaptorException {
		try{
			return dictionariesFacade.getAllDictionray();
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
	}

	@Override
	public Response newDictionary(MultivaluedMap<String, String> formParams) throws AdaptorException {
		try{
			dictionariesFacade.saveNewDictionary(formParams.getFirst("name"), formParams.getFirst("type"));
			return Response.status(Status.CREATED).build();
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
	}

	@Override
	public Response deleteDictionary(MultivaluedMap<String, String> formParams) throws NumberFormatException, AdaptorException {
		String id = formParams.getFirst("id");
		if (id!=null) {
			dictionariesFacade.removeDictionary(Long.valueOf(id));
		}
		
		return Response.status(Status.OK).build();
	}

}
