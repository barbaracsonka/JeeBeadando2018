package hu.oe.word.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.persistence.entity.Dictionary;

@Local
public interface DictionaryService {

	List<Dictionary> getAllDictionray();
	void saveNewDictionary(String name, String type);
	
}
