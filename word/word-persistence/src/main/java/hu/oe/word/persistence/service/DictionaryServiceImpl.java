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

@Stateless(mappedName="ejb/DictionaryService")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DictionaryServiceImpl implements DictionaryService {

	@PersistenceContext(unitName="word-persistence-unit")
	private EntityManager entityManager;

	@Override
	public List<Dictionary> getAllDictionray() {
		return null;
	}

	@Override
	public void saveNewDictionary(String name, String type) {
		entityManager.persist(new Dictionary(name, type));
	}
	
	
}
