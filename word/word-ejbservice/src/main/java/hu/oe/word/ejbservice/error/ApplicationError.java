package hu.oe.word.ejbservice.error;

import javax.ws.rs.core.Response.Status;

import hu.oe.word.ejbservice.stub.ErrorStub;

public enum ApplicationError {

	UNEXPECTED(10,Status.INTERNAL_SERVER_ERROR,"Unexpected error"),
	NOT_EXISTS(40, Status.BAD_REQUEST,"Resource not found");
	
	private final int code;
	private final Status httpStatus;
	private String message;
	
	private ApplicationError(int code, Status httpStatus, String message) {
		this.code = code;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public Status getHttpStatus() {
		return httpStatus;
	}

	public int getCode() {
		return code;
	}
	
	public ErrorStub build(String field) {
		return new ErrorStub(code, message, field);
	}
	
	
}
