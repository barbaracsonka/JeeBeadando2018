package hu.oe.word.ejbservice.stub;

public class ErrorStub {

	private int code;
	private String message;
	private String field;
	
	public ErrorStub(int code, String message, String field) {
		super();
		this.code = code;
		this.message = message;
		this.field = field;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
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
