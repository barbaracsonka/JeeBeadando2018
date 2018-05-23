package hu.oe.word.ejbservice.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import hu.oe.word.ejbservice.stub.TranslationStub;
import hu.oe.word.persistence.entity.Translation;

@Stateless(mappedName="ejb/TranslationConverter")
public class TranslationConverterImpl implements TranslationConverter {

	@Override
	public TranslationStub to(Translation t) {
		if (t == null) {
			return null;
		}
		return new TranslationStub(t.getId(), t.getDictionaryId(), t.getOriginal(), t.getTranslation());
	}

	@Override
	public List<TranslationStub> to(List<Translation> d) {
		if (d == null) {
			return null;
		}
		return d.stream().map(o -> to(o)).collect(Collectors.toList());
	}
}
