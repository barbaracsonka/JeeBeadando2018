package hu.oe.word.ejbservice.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import hu.oe.word.ejbservice.converter.TranslationConverter;
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
	public void removeTranslation(Long id) {
		translationService.removeTranslation(id);
	}

}
