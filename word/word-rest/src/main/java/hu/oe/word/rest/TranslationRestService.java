package hu.oe.word.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.stub.TranslationStub;

@Path("/translations")
public interface TranslationRestService {

	@GET
	@Path("/{dictionaryId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<TranslationStub> getTranslationsForDictionary(@PathParam("dictionaryId") Long dictionaryId) throws AdaptorException;
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	Response newTranslation(MultivaluedMap<String, String> formParams) throws AdaptorException;
	
	@POST
	@Path("/{id}")
	@Consumes("application/x-www-form-urlencoded")
	Response editTranslation(@PathParam("id") Long id, MultivaluedMap<String, String> formParams) throws AdaptorException;
	
	@DELETE
	@Path("/{id}")
	Response deleteTranslation(@PathParam("id") Long id) throws AdaptorException;
}
