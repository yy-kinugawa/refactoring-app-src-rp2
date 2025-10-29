package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;
import jp.co.sss.crud.util.ConstantMsg;

public class MenuNo4EmployeeService implements IEmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();

	private static final MenuNo4EmployeeService menuNo4EmployeeService = new MenuNo4EmployeeService();

	private MenuNo4EmployeeService() {

	}

	/**
	 * インスタンス生成
	 * @return MenuNo4EmployeeService
	 */
	public static MenuNo4EmployeeService getInstance() {
		return menuNo4EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 社員の新規登録
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {

		Employee employee = new Employee();
		consoleWriter.showInputEmployeeName();
		IConsoleReader consoleReader = new EmployeeNameReader();
		employee.setEmpName(consoleReader.input());
		consoleWriter.showInputEmployeeGender();
		consoleReader = new EmployeeGenderReader();
		employee.setGender(consoleReader.input());
		consoleWriter.showInputEmployeeBirthday();
		consoleReader = new EmployeeBirthReader();
		employee.setBirthday(consoleReader.input());
		consoleWriter.showInputDeptId();
		consoleReader = new EmployeeDeptIdReader();
		employee.setDeptId(consoleReader.input());

		IEmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		int ret = employeeDAO.insertEmployee(employee);

		if (ret == 1) {
			consoleWriter.showCompleteInsert();
		} else if (ret == 0) {
			throw new SystemErrorException(ConstantMsg.ERROR_INSERT);
		}
		return true;
	}

}
