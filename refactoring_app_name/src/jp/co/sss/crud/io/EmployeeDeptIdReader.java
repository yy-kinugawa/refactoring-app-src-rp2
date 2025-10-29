package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import jp.co.sss.crud.db.DepartmentDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * コンソールの部署ID入力クラス
 * 
 * @author 絹川
 */

public class EmployeeDeptIdReader implements IConsoleReader {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 部署入力
	 * @return String 部署ID
	 * @throws SystemErrorException
	 * @throws IllegalInputException
	 */
	public String input() throws SystemErrorException, IllegalInputException {
		try {
			String input = br.readLine();

			if (!isValid(input)) {
				List<Department> deptList = DepartmentDAO.findAllDepartment();
				String msg = "";
				for (int i = 0; i < deptList.size(); i++) {
					msg += deptList.get(i).getDeptId();
					if (i < deptList.size() - 1) {
						msg += ".";
					}
				}
				throw new IllegalInputException(msg + ConstantMsg.RANGE_VALIDATION);
			}
			return input;

		} catch (IOException e) {
			throw new SystemErrorException(ConstantMsg.INPUT_ERROR, e);
		}
	}

	/**
	 * バリデーションチェック
	 * @param String 入力(部署ID)
	 * @return boolean
	 * @throws SystemErrorException
	 */
	public boolean isValid(String input) throws SystemErrorException {
		//部署情報の取得
		List<Department> deptList = DepartmentDAO.findAllDepartment();
		//バリデーションチェック(取得した部署ID)
		boolean check = false;
		for (int i = 0; i < deptList.size(); i++) {
			if (input.equals(deptList.get(i).getDeptId())) {
				check = true;
			}
		}
		return check;
	}
}
