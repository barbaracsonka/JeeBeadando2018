package hu.oe.word.ejbservice.stub;

import javax.persistence.Column;


public class DictionaryStub {
	
	private Long id;
	
	public DictionaryStub() {
		super();
	}
	
	public DictionaryStub(Long id ,String name, String type) {
		super();
		this.id = id;
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
