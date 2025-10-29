package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.IConsoleReader;

public class MenuNo3EmployeeService implements IEmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();

	private static final MenuNo3EmployeeService menuNo3EmployeeService = new MenuNo3EmployeeService();

	private MenuNo3EmployeeService() {

	}

	/**
	 * インスタンス生成
	 * @return MenuNo3EmployeeService
	 */
	public static MenuNo3EmployeeService getInstance() {
		return menuNo3EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 部署による検索
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {
		IConsoleReader consoleReader = new EmployeeDeptIdReader();
		consoleWriter.showInputDeptId();
		IEmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		List<Employee> employees = employeeDAO.findEmployeesByDeptId(consoleReader.input());
		consoleWriter.showEmployee(employees);

		return true;
	}

}
