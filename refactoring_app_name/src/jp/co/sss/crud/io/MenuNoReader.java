package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソールのメニューNo入力クラス
 * 
 * @author 絹川
 */
public class MenuNoReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * メニューNO入力
	 * @return String メニューNO
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public String input() throws SystemErrorException, IllegalInputException {
		try {
			String input = br.readLine();
			if (!isValid(input)) {
				throw new IllegalInputException();
			}
			return input;

		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException("1-7" + ConstantMsg.RANGE_VALIDATION);
		}
	}

	/**
	 * バリデーションチェック
	 * @param String 入力(メニューNo)
	 * @return boolean
	 * @throws SystemErrorException
	 */
	public boolean isValid(String input) {
		//1-7の半角数字
		return input.matches("[1-7]{1}");
	}
}
