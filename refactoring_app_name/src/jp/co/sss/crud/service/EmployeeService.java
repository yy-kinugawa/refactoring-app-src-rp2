package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
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

public class EmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();
	private IConsoleReader consoleReader;

	/**
	 * 各機能の呼出
	 * @param int メニューNO
	 */
	public boolean execute(String menuNo) throws SystemErrorException, IllegalInputException {

		switch (menuNo) {

		case "1":
			findAllEmployee();
			return true;
		case "2":
			findEmployeeByName();
			return true;
		case "3":
			findEmployeesByDeptId();
			return true;
		case "4":
			insertEmployee();
			return true;
		case "5":
			updateEmployee();
			return true;
		case "6":
			deleteEmployee();
			return true;
		}
		return false;

	}

	/**
	 * 全件表示機能
	 */
	public void findAllEmployee() throws SystemErrorException, IllegalInputException {
		List<Employee> employees = EmployeeDAO.findAllEmployee();
		consoleWriter.showEmployee(employees);
	}

	/**
	 * 社員名による検索
	 * @param String 検索ワード
	 */
	public void findEmployeeByName() throws SystemErrorException, IllegalInputException {
		consoleReader = new EmployeeNameReader();
		consoleWriter.showInputEmployeeName();
		List<Employee> employees = EmployeeDAO.findEmployeeByName(consoleReader.input());
		consoleWriter.showEmployee(employees);
	}

	/**
	 * 部署による検索
	 * @Param int 部署ID
	 */
	public void findEmployeesByDeptId() throws SystemErrorException, IllegalInputException {
		consoleReader = new EmployeeDeptIdReader();
		consoleWriter.showInputDeptId();
		List<Employee> employees = EmployeeDAO.findEmployeesByDeptId(consoleReader.input());
		consoleWriter.showEmployee(employees);
	}

	/**
	 * 社員の新規登録
	 */
	public void insertEmployee() throws SystemErrorException, IllegalInputException {

		Employee employee = new Employee();
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

		int ret = EmployeeDAO.insertEmployee(employee);

		if (ret == 1) {
			consoleWriter.showCompleteInsert();
		} else if (ret == 0) {
			throw new SystemErrorException(ConstantMsg.ERROR_INSERT);
		}
	}

	/**
	 * 社員情報の更新
	 */
	public void updateEmployee() throws SystemErrorException, IllegalInputException {

		Employee employee = new Employee();
		consoleWriter.showInputEmpIdToUpdate();
		consoleReader = new EmployeeEmpIdReader();
		String empId = consoleReader.input();
		if (!(employeeIdCheck(empId))) {
			consoleWriter.showNoEmployee();
			return;
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

		int ret = EmployeeDAO.updateEmployeeById(employee);

		if (ret == 1) {
			consoleWriter.showCompleteUpdate();
		} else if (ret == 0) {
			throw new SystemErrorException(ConstantMsg.ERROR_UPDATE);
		}
	}

	/**
	 * 社員情報の削除
	 */
	public void deleteEmployee() throws SystemErrorException, IllegalInputException {

		consoleWriter.showInputEmpIdToDelete();
		consoleReader = new EmployeeEmpIdReader();
		String empId = consoleReader.input();
		if (!(employeeIdCheck(empId))) {
			consoleWriter.showNoEmployee();
			return;
		}

		int ret = EmployeeDAO.deleteEmployeeById(empId);

		if (ret == 1) {
			consoleWriter.showCompleteDelete();
		} else if (ret == 0) {
			throw new SystemErrorException(ConstantMsg.ERROR_DELETE);
		}
	}

	/**
	 * 社員IDの存在チェック
	 * @param String 社員ID
	 * @return boolean
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	private boolean employeeIdCheck(String empId) throws IllegalInputException, SystemErrorException {
		List<Employee> empList = EmployeeDAO.findAllEmployee();
		for (Employee e : empList) {
			if (e.getEmpId().equals(empId)) {
				return true;
			}
		}
		return false;
	}
}
