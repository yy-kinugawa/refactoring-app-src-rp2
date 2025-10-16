package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeEmpIdReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 社員ID入力
	 * @return int 社員ID
	 * @throws IOException
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

	public boolean isValid(String input) {
		return input.matches("^[0-9]+$");
	}
}
