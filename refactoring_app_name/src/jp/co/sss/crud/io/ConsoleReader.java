package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * コンソールの入力クラス
 * 
 *  @author 絹川
 */

public class ConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * メニューNO入力
	 * @return int メニューNO
	 * @throws IOException
	 */
	public int inputMenuNumber() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	/**
	 * 社員名ワード入力
	 * @return String 検索ワード
	 * @throws IOException
	 */
	public String inputSearchWord() throws IOException {
		return br.readLine();
	}

	/**
	 * 社員ID入力
	 * @return int 社員ID
	 * @throws IOException
	 */
	public int inputEmployeeId() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	/**
	 * 社員名入力
	 * @return String 社員名
	 * @throws IOException
	 */
	public String inputEmployeeName() throws IOException {
		return br.readLine();
	}

	/**
	 * 性別入力
	 * @return int 性別
	 * @throws IOException
	 */
	public int inputEmployeeGender() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	/**
	 * 誕生日入力
	 * @return String 誕生日(yyyy/mm/dd)
	 * @throws IOException
	 */
	public Date inputEmployeeBirthday() throws IOException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.parse(br.readLine());
	}

	/**
	 * 部署入力
	 * @return int 部署ID
	 * @throws IOException
	 */
	public int inputEmployeeDeptId() throws IOException {
		return Integer.parseInt(br.readLine());
	}

}
