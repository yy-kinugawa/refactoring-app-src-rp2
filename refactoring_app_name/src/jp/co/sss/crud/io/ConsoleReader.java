package jp.co.sss.crud.io;

/**
 * コンソールの入力クラス
 * 
 *  @author 絹川
 */

public class ConsoleReader {

	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//
	//	/**
	//	 * メニューNO入力
	//	 * @return int メニューNO
	//	 * @throws SystemErrorException
	//	 */
	//	public int inputMenuNumber() throws SystemErrorException, IllegalInputException {
	//		try {
	//			int input = Integer.parseInt(br.readLine());
	//			if (!isValid(input)) {
	//				throw new IllegalInputException("1-7" + ConstantMsg.RANGE_VALIDATION);
	//			}
	//			return input;
	//
	//		} catch (IOException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}
	//
	//	/**
	//	 * 社員名ワード入力
	//	 * @return String 検索ワード
	//	 * @throws IOException
	//	 */
	//	public String inputSearchWord() throws SystemErrorException {
	//		try {
	//			return br.readLine();
	//
	//		} catch (IOException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}
	//
	//	/**
	//	 * 社員ID入力
	//	 * @return int 社員ID
	//	 * @throws IOException
	//	 */
	//	public int inputEmployeeId() throws SystemErrorException, IllegalInputException {
	//		try {
	//			int input = Integer.parseInt(br.readLine());
	//			if (!isValid(input)) {
	//				throw new IllegalInputException(ConstantMsg.NUMBER_VALIDATION);
	//			}
	//			return input;
	//
	//		} catch (IOException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}
	//
	//	/**
	//	 * 社員名入力
	//	 * @return String 社員名
	//	 * @throws IOException
	//	 */
	//	public String inputEmployeeName() throws SystemErrorException, IllegalInputException {
	//		try {
	//			String input = br.readLine();
	//			if (!isValid(input)) {
	//				throw new IllegalInputException(ConstantMsg.SIZE_VALIDATION);
	//			}
	//			return input;
	//
	//		} catch (IOException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}
	//
	//	/**
	//	 * 性別入力
	//	 * @return int 性別
	//	 * @throws IOException
	//	 */
	//	public int inputEmployeeGender() throws SystemErrorException, IllegalInputException {
	//		try {
	//			int input = Integer.parseInt(br.readLine());
	//			if (!isValid(input)) {
	//				throw new IllegalInputException("0.1.2.9" + ConstantMsg.RANGE_VALIDATION);
	//			}
	//			return input;
	//
	//		} catch (IOException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}
	//
	//	/**
	//	 * 誕生日入力
	//	 * @return String 誕生日(yyyy/mm/dd)
	//	 * @throws IOException
	//	 */
	//	public Date inputEmployeeBirthday() throws SystemErrorException, IllegalInputException {
	//		try {
	//			String date = br.readLine();
	//			if (!isValid(date)) {
	//				throw new IllegalInputException(ConstantMsg.DATE_VALIDATION);
	//			}
	//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	//			return sdf.parse(date);
	//		} catch (IOException | ParseException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}
	//
	//	/**
	//	 * 部署入力
	//	 * @return int 部署ID
	//	 * @throws IOException
	//	 */
	//	public int inputEmployeeDeptId() throws SystemErrorException, IllegalInputException {
	//		try {
	//			int input = Integer.parseInt(br.readLine());
	//			if (!isValid(input)) {
	//				throw new IllegalInputException("1.2.3" + ConstantMsg.RANGE_VALIDATION);
	//			}
	//			return input;
	//
	//		} catch (IOException e) {
	//			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
	//		}
	//	}*/

}
