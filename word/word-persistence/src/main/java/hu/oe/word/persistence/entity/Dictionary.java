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
@Table(name="dictionary")
@NamedQueries( value = {
	@NamedQuery(name = Dictionary.GET_ALL,query = "SELECT b FROM Dictionary b order by b.name")
	
})
public class Dictionary {
	
	public static final String GET_ALL = "Dictionary.getAll";
	
	@Id
	@SequenceGenerator(name="generatorDictionary", sequenceName="dictionary_id_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorDictionary")
	@Column(name="id",nullable=false)
	private Long id;
	
	public Dictionary() {
		super();
	}
	
	public Dictionary(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	@Column(name="name")
	private String name;
	
	@Column(name="type")
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
