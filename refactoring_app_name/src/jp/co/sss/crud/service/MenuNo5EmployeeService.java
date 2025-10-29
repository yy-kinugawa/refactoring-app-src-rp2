package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;
import jp.co.sss.crud.util.ConstantMsg;

public class MenuNo5EmployeeService implements IEmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();

	private static final MenuNo5EmployeeService menuNo5EmployeeService = new MenuNo5EmployeeService();

	private MenuNo5EmployeeService() {

	}

	/**
	 * インスタンス生成
	 * @return MenuNo5EmployeeService
	 */
	public static MenuNo5EmployeeService getInstance() {
		return menuNo5EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 社員情報の更新
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {

		Employee employee = new Employee();
		consoleWriter.showInputEmpIdToUpdate();
		IConsoleReader consoleReader = new EmployeeEmpIdReader();
		String empId = consoleReader.input();
		if (!(IEmployeeService.employeeIdCheck(empId))) {
			consoleWriter.showNoEmployee();
			return true;
		}
		employee.setEmpId(empId);
		consoleWriter.showInputEmployeeName();
		consoleReader = new EmployeeNameReader();
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
		int ret = employeeDAO.updateEmployeeById(employee);

		if (ret == 1) {
			consoleWriter.showCompleteUpdate();
		} else if (ret == 0) {
			throw new SystemErrorException(ConstantMsg.ERROR_UPDATE);
		}

		return true;
	}

}
