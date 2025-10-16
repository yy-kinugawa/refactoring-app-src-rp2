package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.Gender;

public class EmployeeGenderReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 性別入力
	 * @return int 性別
	 * @throws IOException
	 */
	public String input() throws SystemErrorException, IllegalInputException {
		try {
			String input = br.readLine();
			if (!isValid(input)) {
				Gender[] genderList = Gender.values();
				String genderNum = "";
				for (int i = 0; i < genderList.length; i++) {
					genderNum += genderList[i].getNumber();
					if (i < genderList.length - 1) {
						genderNum += ".";
					}
				}
				throw new IllegalInputException(genderNum + ConstantMsg.RANGE_VALIDATION);
			}
			return input;

		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
		}
	}

	public boolean isValid(String input) {
		Gender[] genderList = Gender.values();
		boolean check = false;
		for (int i = 0; i < genderList.length; i++) {
			if (input.equals(genderList[i].getNumber())) {
				check = true;
			}
		}
		return check;
	}
}
