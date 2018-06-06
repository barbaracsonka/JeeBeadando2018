package hu.oe.word.ejbservice.error;

import javax.ws.rs.core.Response.Status;

import hu.oe.word.ejbservice.stub.ErrorStub;

public class AdaptorException extends Exception {

	private final ApplicationError error;
	private final String field;
	
	public AdaptorException(ApplicationError error, String field, String message) {
		super(message);
		this.error = error;
		this.field = field;
	};
	
	public ErrorStub build(){
		return this.error.build(field);
	}
	
	public Status getHttpStatus(){
		return error.getHttpStatus();
	}
}
