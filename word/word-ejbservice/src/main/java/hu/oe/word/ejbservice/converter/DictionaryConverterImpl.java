package hu.oe.word.ejbservice.converter;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;

import hu.oe.word.ejbservice.stub.DictionaryStub;
import hu.oe.word.persistence.entity.Dictionary;

@Stateless(mappedName="ejb/DictionaryConverter")
public class DictionaryConverterImpl implements DictionaryConverter {

	@Override
	public DictionaryStub to(Dictionary d) {
		if (d == null) {
			return null;
		}
		return new DictionaryStub(d.getId(), d.getName(), d.getType());
	}

	@Override
	public List<DictionaryStub> to(List<Dictionary> d) {
		if (d == null) {
			return null;
		}
		return d.stream().map(o -> to(o)).collect(Collectors.toList());
	}
}
