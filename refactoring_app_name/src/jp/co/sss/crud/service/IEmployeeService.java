package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

/**
 * 社員情報サービスのインターフェース
 * 
 * @author 絹川
 */
public interface IEmployeeService {

	/**
	 * メニューNoによってインスタンス生成
	 * @param String menuNo
	 * @return IEmployeeService 
	 */
	public static IEmployeeService getInstanceByMenuNo(String menuNo) {
		switch (menuNo) {

		case "1":
			return MenuNo1EmployeeService.getInstance();
		case "2":
			return MenuNo2EmployeeService.getInstance();
		case "3":
			return MenuNo3EmployeeService.getInstance();
		case "4":
			return MenuNo4EmployeeService.getInstance();
		case "5":
			return MenuNo5EmployeeService.getInstance();
		case "6":
			return MenuNo6EmployeeService.getInstance();
		}
		return MenuNo7EmployeeService.getInstance();
	}

	/**
	 * メニュー機能実行
	 * @return boolean
	 * @throws SystemErrorException 
	 * @throws IllegalInputException
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException;

	/**
	 * 社員IDの存在チェック
	 * @param String 社員ID
	 * @return boolean
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public static boolean employeeIdCheck(String empId) throws IllegalInputException, SystemErrorException {
		IEmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		List<Employee> empList = employeeDAO.findAllEmployee();
		for (Employee e : empList) {
			if (e.getEmpId().equals(empId)) {
				return true;
			}
		}
		return false;
	}

}
