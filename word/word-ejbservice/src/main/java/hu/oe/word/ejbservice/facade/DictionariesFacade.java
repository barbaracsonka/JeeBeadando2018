package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.persistence.entity.Dictionary;

@Local
public interface DictionariesFacade {

	List<Dictionary> getAllDictionray();
	
	void saveNewDictionary(String name, String type);
}
