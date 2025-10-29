package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

/**
 * 社員情報サービス(全件表示)
 * 
 * @author 絹川
 */
public class MenuNo1EmployeeService implements IEmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();
	private static final MenuNo1EmployeeService menuNo1EmployeeService = new MenuNo1EmployeeService();

	/** インスタンス化を禁止 */
	private MenuNo1EmployeeService() {
	}

	/**
	 * インスタンス生成
	 * @return MenuNo1EmployeeService
	 */
	public static MenuNo1EmployeeService getInstance() {
		return menuNo1EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 全件表示機能
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {
		//社員情報の取得
		IEmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		List<Employee> employees = employeeDAO.findAllEmployee();
		//社員情報の表示
		consoleWriter.showEmployee(employees);

		return true;
	}

}
