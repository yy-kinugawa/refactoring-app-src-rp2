package jp.co.sss.crud.exception;

/**
 * 独自例外クラス(継続不能なエラー)
 * 
 * @author 絹川
 */

public class SystemErrorException extends Exception {

	//エラーメッセージ
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
