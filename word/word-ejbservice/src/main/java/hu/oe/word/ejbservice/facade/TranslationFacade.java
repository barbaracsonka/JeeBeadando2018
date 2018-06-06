package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.stub.TranslationStub;

@Local
public interface TranslationFacade {

	List<TranslationStub> getAllTranslationByDictionaryId(Long DictionaryId);
	void saveNewTranslation(Long dictionaryId, String from, String to);
	void removeTranslation(Long id) throws AdaptorException;
	TranslationStub getTranslationById(Long id);
	void editTranslation(Long id, String from, String to) throws AdaptorException;
}
