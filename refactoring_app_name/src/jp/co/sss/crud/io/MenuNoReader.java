package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

public class MenuNoReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * メニューNO入力
	 * @return int メニューNO
	 * @throws SystemErrorException
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

	public boolean isValid(String input) {
		return input.matches("[1-7]{1}");
	}
}
