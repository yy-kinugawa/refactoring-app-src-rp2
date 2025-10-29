package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.db.IEmployeeDAO;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.IConsoleReader;
import jp.co.sss.crud.util.ConstantMsg;

/**
 * 社員情報サービス(削除)
 * 
 * @author 絹川
 */
public class MenuNo6EmployeeService implements IEmployeeService {

	private ConsoleWriter consoleWriter = new ConsoleWriter();
	private static final MenuNo6EmployeeService menuNo6EmployeeService = new MenuNo6EmployeeService();

	/** インスタンス化を禁止 */
	private MenuNo6EmployeeService() {
	}

	/**
	 * インスタンス生成
	 * @return MenuNo6EmployeeService
	 */
	public static MenuNo6EmployeeService getInstance() {
		return menuNo6EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 社員情報の削除
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {

		//社員IDの入力
		consoleWriter.showInputEmpIdToDelete();
		IConsoleReader consoleReader = new EmployeeEmpIdReader();
		String empId = consoleReader.input();
		//存在しなかった場合メッセージを表示
		if (!(IEmployeeService.employeeIdCheck(empId))) {
			consoleWriter.showNoEmployee();
			return true;
		}

		//社員情報の削除
		IEmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		int ret = employeeDAO.deleteEmployeeById(empId);

		//削除メッセージの表示
		if (ret == 1) {
			consoleWriter.showCompleteDelete();
		} else if (ret == 0) {
			throw new SystemErrorException(ConstantMsg.ERROR_DELETE);
		}

		return true;
	}
}
