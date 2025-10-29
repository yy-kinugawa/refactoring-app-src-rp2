package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソールの社員ID入力クラス
 * 
 * @author 絹川
 */
public class EmployeeEmpIdReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 社員ID入力
	 * @return String 社員ID
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public String input() throws SystemErrorException, IllegalInputException {
		try {
			String input = br.readLine();
			if (!isValid(input)) {
				throw new IllegalInputException(ConstantMsg.NUMBER_VALIDATION);
			}
			return input;

		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
		}
	}

	/**
	 * バリデーションチェック
	 * @param String 入力(社員ID)
	 * @return boolean
	 * @throws SystemErrorException
	 */
	public boolean isValid(String input) {
		//半角数字
		return input.matches("^[0-9]+$");
	}
}
