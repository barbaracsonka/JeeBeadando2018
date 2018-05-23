package hu.oe.word.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="translation")
@NamedQueries( value = {
		@NamedQuery(name = Translation.GET_ALL_BY_DICTIONARY_ID,query = "SELECT b FROM Translation b WHERE b.dictionaryId = :dictionaryId order by b.original"),
		@NamedQuery(name = Translation.DELETE_ONE,query = "DELETE FROM Translation b WHERE b.id = :id")
	})
public class Translation {
	

	public static final String GET_ALL_BY_DICTIONARY_ID = "Translation.getAllByDictionaryId";
	public static final String DELETE_ONE = "Translation.delete";
	
	public Translation(Long dictionaryId, String original, String translation) {
		super();
		this.dictionaryId = dictionaryId;
		this.original = original;
		this.translation = translation;
	}
	
	
	public Translation() {
		super();
	}


	@Id
	@SequenceGenerator(name="generatorTranslation", sequenceName="translation_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorTranslation")
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name="dictionary_id",nullable=false)
	private Long dictionaryId;
	
	@Column(name="original",nullable=false)
	private String original;
	
	@Column(name="translation",nullable=false)
	private String translation;

	public Long getId() {
		return id;
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
