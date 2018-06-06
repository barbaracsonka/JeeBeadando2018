package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.word.ejbservice.converter.DictionaryConverter;
import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.error.ApplicationError;
import hu.oe.word.ejbservice.stub.DictionaryStub;
import hu.oe.word.persistence.entity.Dictionary;
import hu.oe.word.persistence.service.DictionaryService;

@Stateless(mappedName = "ejb/DictionariesFacade")
public class DictionariesFacadeImpl implements DictionariesFacade {

	@EJB
	private DictionaryService dictionaryService;
	
	@EJB 
	private DictionaryConverter dictionaryConverter;
	
	
	@Override
	public List<DictionaryStub> getAllDictionray() {
		List<Dictionary> list = dictionaryService.getAllDictionray();
		return dictionaryConverter.to(list);
	}

	@Override
	public void saveNewDictionary(String name, String type) {
		dictionaryService.saveNewDictionary(name, type);
	}

	@Override
	public void removeDictionary(Long id) throws AdaptorException {
		if (dictionaryService.exists(id)) {
			dictionaryService.removeDictionary(id);
		}else{
			throw new AdaptorException(ApplicationError.NOT_EXISTS, id.toString(), "Dictionary not found");
		}
	}

}
