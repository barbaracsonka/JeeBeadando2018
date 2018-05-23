package hu.oe.word.ejbservice.converter;

import java.util.List;

import javax.ejb.Local;

import hu.oe.word.ejbservice.stub.TranslationStub;
import hu.oe.word.persistence.entity.Translation;

@Local
public interface TranslationConverter {
	TranslationStub to(Translation t);
	List<TranslationStub> to(List<Translation> t);
}
