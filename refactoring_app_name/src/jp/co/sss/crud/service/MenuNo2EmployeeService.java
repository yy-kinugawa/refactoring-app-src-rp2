package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;

/**
 * 社員情報サービス(社員名検索)
 * 
 * @author 絹川
 */
public class MenuNo2EmployeeService implements IEmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();
	private static final MenuNo2EmployeeService menuNo2EmployeeService = new MenuNo2EmployeeService();

	/** インスタンス化を禁止 */
	private MenuNo2EmployeeService() {
	}

	/**
	 * インスタンス生成
	 * @return MenuNo2EmployeeService
	 */
	public static MenuNo2EmployeeService getInstance() {
		return menuNo2EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 社員名による検索
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {
		//社員名入力
		IConsoleReader consoleReader = new EmployeeNameReader();
		consoleWriter.showInputEmployeeName();
		IEmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		//社員情報の取得
		List<Employee> employees = employeeDAO.findEmployeeByName(consoleReader.input());
		//社員情報の表示
		consoleWriter.showEmployee(employees);

		return true;
	}

}
