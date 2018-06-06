package hu.oe.word.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.stub.DictionaryStub;

@Path("/dictionary")
public interface DictionrayRestService {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	List<DictionaryStub> getAllDictionary() throws AdaptorException;
	
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	Response newDictionary(MultivaluedMap<String, String> formParams) throws AdaptorException;
	
	@DELETE
	@Consumes("application/x-www-form-urlencoded")
	Response deleteDictionary(MultivaluedMap<String, String> formParams) throws NumberFormatException, AdaptorException;
}
