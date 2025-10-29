package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

/**
 * コンソールの入力インターフェース
 * 
 * @author 絹川
 */

public interface IConsoleReader {

	/**
	 * バリデーションチェック
	 * @param String 入力テキスト
	 * @return boolean
	 * @throws SystemErrorException
	 */
	public boolean isValid(String input) throws SystemErrorException;

	/**
	 * コンソールの入力
	 * @return Stirng 入力された値
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public String input() throws SystemErrorException, IllegalInputException;
}
