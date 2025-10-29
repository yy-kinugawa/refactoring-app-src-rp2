package jp.co.sss.crud.service;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

/**
 * 社員情報サービス(終了)
 * 
 * @author 絹川
 */
public class MenuNo7EmployeeService implements IEmployeeService {

	private static final MenuNo7EmployeeService menuNo7EmployeeService = new MenuNo7EmployeeService();

	/** インスタンス化を禁止 */
	private MenuNo7EmployeeService() {
	}

	/**
	 * インスタンス生成
	 * @return MenuNo7EmployeeService
	 */
	public static MenuNo7EmployeeService getInstance() {
		return menuNo7EmployeeService;
	}

	/**
	 * メニュー機能実行
	 * 終了機能
	 * @return boolean
	 */
	public boolean execute() throws SystemErrorException, IllegalInputException {
		return false;
	}

}
