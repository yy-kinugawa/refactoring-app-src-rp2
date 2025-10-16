package jp.co.sss.crud.io;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public interface IConsoleReader {

	public boolean isValid(String input) throws SystemErrorException;

	public String input() throws SystemErrorException, IllegalInputException;
}
