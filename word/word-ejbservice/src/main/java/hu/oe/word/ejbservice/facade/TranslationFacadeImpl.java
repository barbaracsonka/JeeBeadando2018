package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.word.ejbservice.converter.TranslationConverter;
import hu.oe.word.ejbservice.error.AdaptorException;
import hu.oe.word.ejbservice.error.ApplicationError;
import hu.oe.word.ejbservice.stub.TranslationStub;
import hu.oe.word.persistence.entity.Translation;
import hu.oe.word.persistence.service.TranslationService;


@Stateless(mappedName = "ejb/TranslationFacade")
public class TranslationFacadeImpl implements TranslationFacade {
	
	@EJB
	private TranslationService translationService;

	@EJB 
	private TranslationConverter translationConverter;


	@Override
	public List<TranslationStub> getAllTranslationByDictionaryId(Long id) {
		List<Translation> list = translationService.getAllTranslationByDictionaryId(id);
		return translationConverter.to(list);
	}

	@Override
	public void saveNewTranslation(Long dictionaryId, String from, String to) {
		translationService.saveNewTranslation(dictionaryId, from, to);
	}
	
	@Override
	public void editTranslation(Long id, String from, String to) throws AdaptorException {
		if (translationService.exists(id)) {
			translationService.editTranslation(id, from, to);
		} else {
			throw new AdaptorException(ApplicationError.UNEXPECTED, id.toString(), "Translation not found!");
		}
	}

	@Override
	public void removeTranslation(Long id) throws AdaptorException {
		if (translationService.exists(id)) {
			translationService.removeTranslation(id);
		} else {
			throw new AdaptorException(ApplicationError.UNEXPECTED, id.toString(), "Translation not found!");
		}
	}

	@Override
	public TranslationStub getTranslationById(Long id) {
		Translation t = translationService.getTranslationById(id);
		return translationConverter.to(t);
	}

}
