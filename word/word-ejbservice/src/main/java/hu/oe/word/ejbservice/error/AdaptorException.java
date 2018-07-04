package hu.oe.word.ejbservice.error;

import javax.ws.rs.core.Response.Status;
import javax.xml.ws.WebFault;

import hu.oe.word.ejbservice.stub.ErrorStub;

@WebFault(targetNamespace="http://www.word.hu/Word", name = "WordFault" )
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
	
	public ErrorStub getFaultInfo(){
		return this.error.build(field);
	} 
}
