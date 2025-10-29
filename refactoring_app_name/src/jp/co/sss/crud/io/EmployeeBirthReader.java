package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソールの誕生日入力クラス
 * 
 * @author 絹川
 */

public class EmployeeBirthReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 誕生日入力
	 * @return String 誕生日(yyyy/mm/dd)
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public String input() throws SystemErrorException, IllegalInputException {
		try {
			String date = br.readLine();
			if (!isValid(date)) {
				throw new IllegalInputException(ConstantMsg.DATE_VALIDATION);
			}
			return date;
		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
		}
	}

	/**
	 * バリデーションチェック
	 * @param String 入力(誕生日)
	 * @return boolean
	 * @throws SystemErrorException
	 */
	public boolean isValid(String input) {
		//yyyy/mm/dd
		return input.matches("^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$");
	}
}
