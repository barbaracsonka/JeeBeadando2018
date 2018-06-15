package hu.oe.word.ejbservice.stub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Dictionary")
@XmlAccessorType(XmlAccessType.FIELD)
public class DictionaryStub {
	
	@XmlAttribute(name = "id")
	private Long id;
	
	@XmlAttribute(name = "name")	
	private String name;
	
	@XmlAttribute(name = "type")
	private String type;
	
	public DictionaryStub() {
		super();
	}
	
	public DictionaryStub(Long id ,String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

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
