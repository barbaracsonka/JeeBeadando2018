package hu.oe.word.ejbservice.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Dictionary")
@XmlAccessorType(XmlAccessType.FIELD)
public class TranslationStub {
	

	public static final String GET_ALL = "Translation.getAll";
	public static final String DELETE_ONE = "Translation.delete";
	
	public TranslationStub(Long dictionaryId, String original, String translation) {
		super();
		this.dictionaryId = dictionaryId;
		this.original = original;
		this.translation = translation;
	}
	
	public TranslationStub(Long id, Long dictionaryId, String original, String translation) {
		super();
		this.id = id;
		this.dictionaryId = dictionaryId;
		this.original = original;
		this.translation = translation;
	}

	public TranslationStub() {
		super();
	}
	
	@XmlAttribute(name = "id")
	private Long id;
	
	@XmlAttribute(name = "dictionaryId")
	private Long dictionaryId;
	
	@XmlAttribute(name = "original")
	private String original;

	@XmlAttribute(name = "translation")
	private String translation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDictionaryId() {
		return dictionaryId;
	}

	public void setDictionaryId(Long dictionaryId) {
		this.dictionaryId = dictionaryId;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	
}
