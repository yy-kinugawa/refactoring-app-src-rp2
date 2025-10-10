package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleReader;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();
	private ConsoleReader consoleReader = new ConsoleReader();

	/**
	 * 各機能の呼出
	 * @param int メニューNO
	 */
	public boolean execute(int menuNo) throws ClassNotFoundException, SQLException, IOException, ParseException {

		switch (menuNo) {

		case 1:
			findAllEmployee();
			return true;
		case 2:
			findEmployeeByName();
			return true;
		case 3:
			findEmployeesByDeptId();
			return true;
		case 4:
			insertEmployee();
			return true;
		case 5:
			updateEmployee();
			return true;
		case 6:
			deleteEmployee();
			return true;
		}
		return false;

	}

	/**
	 * 全件表示機能
	 */
	public void findAllEmployee() throws ClassNotFoundException, SQLException, IOException, ParseException {
		List<Employee> employees = EmployeeDAO.findAllEmployee();
		consoleWriter.showEmployee(employees);
	}

	/**
	 * 社員名による検索
	 * @param String 検索ワード
	 */
	public void findEmployeeByName() throws ClassNotFoundException, SQLException, IOException, ParseException {
		consoleWriter.showInputEmployeeName();
		List<Employee> employees = EmployeeDAO.findEmployeeByName(consoleReader.inputSearchWord());
		consoleWriter.showEmployee(employees);
	}

	/**
	 * 部署による検索
	 * @Param int 部署ID
	 */
	public void findEmployeesByDeptId() throws ClassNotFoundException, SQLException, IOException, ParseException {
		consoleWriter.showInputDeptId();
		List<Employee> employees = EmployeeDAO.findEmployeesByDeptId(consoleReader.inputEmployeeDeptId());
		consoleWriter.showEmployee(employees);
	}

	/**
	 * 社員の新規登録
	 */
	public void insertEmployee() throws ClassNotFoundException, SQLException, IOException, ParseException {

		Employee employee = new Employee();
		consoleWriter.showInputEmployeeName();
		employee.setEmpName(consoleReader.inputEmployeeName());
		consoleWriter.showInputEmployeeGender();
		employee.setGender(consoleReader.inputEmployeeGender());
		consoleWriter.showInputEmployeeBirthday();
		employee.setBirthday(consoleReader.inputEmployeeBirthday());
		consoleWriter.showInputDeptId();
		employee.setDeptId(consoleReader.inputEmployeeDeptId());

		int n = EmployeeDAO.insertEmployee(employee);
	}

	/**
	 * 社員情報の更新
	 */
	public void updateEmployee() throws ClassNotFoundException, SQLException, IOException, ParseException {

		Employee employee = new Employee();
		consoleWriter.showInputEmpIdToUpdate();
		employee.setEmpId(consoleReader.inputEmployeeId());
		consoleWriter.showInputEmployeeName();
		employee.setEmpName(consoleReader.inputEmployeeName());
		consoleWriter.showInputEmployeeGender();
		employee.setGender(consoleReader.inputEmployeeGender());
		consoleWriter.showInputEmployeeBirthday();
		employee.setBirthday(consoleReader.inputEmployeeBirthday());
		consoleWriter.showInputDeptId();
		employee.setDeptId(consoleReader.inputEmployeeDeptId());

		int n = EmployeeDAO.updateEmployeeById(employee);
	}

	/**
	 * 社員情報の削除
	 */
	public void deleteEmployee() throws ClassNotFoundException, SQLException, IOException, ParseException {

		consoleWriter.showInputEmpIdToDelete();
		int empId = consoleReader.inputEmployeeId();

		int n = EmployeeDAO.deleteEmployeeById(empId);
	}
}
