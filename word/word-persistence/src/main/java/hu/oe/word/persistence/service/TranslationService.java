package hu.oe.word.persistence.service;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.persistence.entity.Dictionary;
import hu.oe.word.persistence.entity.Translation;

@Local
public interface TranslationService {

	List<Translation> getAllTranslationByDictionaryId(Long id);
	void saveNewTranslation(Long dictionaryId, String from,String to);
	void editTranslation(Long id, String from,String to);
	int removeTranslation(Long id);
	Translation getTranslationById(Long id);
	boolean exists(Long id);
	
}
