package hu.oe.word.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.error.ApplicationError;
import hu.oe.word.ejbservice.facade.TranslationFacade;
import hu.oe.word.ejbservice.stub.TranslationStub;

@Stateless
public class TranslationRestServiceImpl implements TranslationRestService {

	@EJB
	private TranslationFacade translationFacade;
	
	@Override
	public List<TranslationStub> getTranslationsForDictionary(Long dictionaryId) throws AdaptorException {
		try{
			return translationFacade.getAllTranslationByDictionaryId(dictionaryId);
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
	}

	@Override
	public Response newTranslation(MultivaluedMap<String, String> formParams) throws AdaptorException {
		try{
			translationFacade.saveNewTranslation(Long.valueOf(formParams.getFirst("dictionaryid")), formParams.getFirst("from"), formParams.getFirst("to"));
		} catch (Exception e) {
			throw new AdaptorException(ApplicationError.UNEXPECTED,"","Something went wrong!");
		}
		return Response.ok().build();
	}

	@Override
	public Response deleteTranslation(Long id) throws AdaptorException {
		translationFacade.removeTranslation(id);
		return Response.status(Status.OK).build();
	}

	@Override
	public Response editTranslation(Long id, MultivaluedMap<String, String> formParams) throws AdaptorException {
		translationFacade.editTranslation(id, formParams.getFirst("from"), formParams.getFirst("to"));
		return Response.status(Status.OK).build();
	}
}
