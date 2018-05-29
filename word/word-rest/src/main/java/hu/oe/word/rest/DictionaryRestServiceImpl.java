package hu.oe.word.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.word.ejbservice.facade.DictionariesFacade;
import hu.oe.word.ejbservice.stub.DictionaryStub;

@Stateless
public class DictionaryRestServiceImpl implements DictionrayRestService {

	@EJB
	private DictionariesFacade dictionariesFacade;
	
	@Override
	public List<DictionaryStub> getAllDictionary() {
		return dictionariesFacade.getAllDictionray();
	}

}
