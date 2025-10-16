package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {

	private String errorMessage;

	public SystemErrorException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public SystemErrorException(String errorMessage, Exception e) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
