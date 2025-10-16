package jp.co.sss.crud.exception;

public class IllegalInputException extends RuntimeException {

	private String illegalInputMessage;

	public IllegalInputException() {
	}

	public IllegalInputException(String illegalInputMessage) {
		this.illegalInputMessage = illegalInputMessage;
	}

	public String getIllegalInputMessage() {
		return illegalInputMessage;
	}

	public void setIllegalInputMessage(String illegalInputMessage) {
		this.illegalInputMessage = illegalInputMessage;
	}

}
