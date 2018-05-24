package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.ejbservice.stub.TranslationStub;

@Local
public interface TranslationFacade {

	List<TranslationStub> getAllTranslationByDictionaryId(Long DictionaryId);
	void saveNewTranslation(Long dictionaryId, String from, String to);
	void removeTranslation(Long id);
	TranslationStub getTranslationById(Long id);
	void editTranslation(Long id, Long dictionaryId, String from, String to);
}
