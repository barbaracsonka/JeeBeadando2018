package hu.oe.word.ejbservice.stub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ServiceError")
public class ErrorStub implements Serializable{

	public ErrorStub() {
		this(10, null, null);
	}
	private static final long serialVersionUID = 2751598970173721446L;
	
	private int code;
	private String message;
	private String field;
	
	public ErrorStub(int code, String message, String field) {
		super();
		this.code = code;
		this.message = message;
		this.field = field;
	}
	
	@XmlElement(name="code")
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@XmlElement(name="message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
}