package jp.co.sss.crud.exception;

/**
 * 独自例外クラス(不正な入力)
 * 
 * @author 絹川
 */

public class IllegalInputException extends RuntimeException {

	//エラーメッセージ
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
