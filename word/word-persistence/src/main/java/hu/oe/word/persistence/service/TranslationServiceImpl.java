package hu.oe.word.persistence.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hu.oe.word.persistence.entity.Dictionary;
import hu.oe.word.persistence.entity.Translation;

@Stateless(mappedName="ejb/TranslationService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TranslationServiceImpl implements TranslationService {

	@PersistenceContext(unitName="word-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<Translation> getAllTranslationByDictionaryId(Long id) {
		return entityManager
				.createNamedQuery(Translation.GET_ALL_BY_DICTIONARY_ID,Translation.class)
				.setParameter("dictionaryId", id)
				.getResultList();
	}
	
	@Override
	public Translation getTranslationById(Long id) {
		return entityManager
				.createNamedQuery(Translation.GET_TRANSLATION_BY_ID,Translation.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public void saveNewTranslation(Long dictionaryId, String from,String to) {
		entityManager.persist(new Translation(dictionaryId,from,to));
	}
	
	@Override
	public void editTranslation(Long id, Long dictionaryId, String from,String to) {
		Translation t = entityManager.find(Translation.class, id);
		t.setOriginal(from);
		t.setTranslation(to);
	}

	@Override
	public void removeTranslation(Long id) {
		entityManager.createNamedQuery(Translation.DELETE_ONE).setParameter("id", id).executeUpdate();
	}
}
