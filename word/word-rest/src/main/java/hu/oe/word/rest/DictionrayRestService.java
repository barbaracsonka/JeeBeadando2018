package hu.oe.word.rest;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hu.oe.word.ejbservice.stub.DictionaryStub;

@Path("/dictionary")
public interface DictionrayRestService {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	List<DictionaryStub> getAllDictionary();
}
