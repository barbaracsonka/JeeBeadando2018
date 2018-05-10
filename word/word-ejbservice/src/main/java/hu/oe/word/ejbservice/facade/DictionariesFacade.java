package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.ejbservice.stub.DictionaryStub;

@Local
public interface DictionariesFacade {

	List<DictionaryStub> getAllDictionray();
	
	void saveNewDictionary(String name, String type);
}
