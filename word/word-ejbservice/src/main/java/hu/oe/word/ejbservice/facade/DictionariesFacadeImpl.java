package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.word.persistence.entity.Dictionary;
import hu.oe.word.persistence.service.DictionaryService;

@Stateless(mappedName = "ejb/DictionariesFacade")
public class DictionariesFacadeImpl implements DictionariesFacade {

	@EJB
	private DictionaryService dictionaryService;
	
	
	@Override
	public List<Dictionary> getAllDictionray() {
		//TODO
		return null;
	}

	@Override
	public void saveNewDictionary(String name, String type) {
		dictionaryService.saveNewDictionary(name, type);
	}

}
