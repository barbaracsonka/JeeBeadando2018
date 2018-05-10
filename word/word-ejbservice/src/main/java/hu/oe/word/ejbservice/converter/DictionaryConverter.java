package hu.oe.word.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.ejbservice.stub.DictionaryStub;
import hu.oe.word.persistence.entity.Dictionary;

@Local
public interface DictionaryConverter {

	DictionaryStub to(Dictionary d);
	List<DictionaryStub> to(List<Dictionary> d);
	
}
