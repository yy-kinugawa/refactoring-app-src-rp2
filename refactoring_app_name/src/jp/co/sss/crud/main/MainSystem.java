package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author 絹川
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws SystemErrorException, IllegalInputException {
		MenuNoReader menuNoReader = new MenuNoReader();
		ConsoleWriter consoleWriter = new ConsoleWriter();

		boolean endCheck = true;

		do {
			try {//メニューの表示
				consoleWriter.showMenu();

				//メニュー番号の入力
				String menuNo = menuNoReader.input();

				//各機能インスタンス生成
				IEmployeeService employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);

				// 機能の呼出
				endCheck = employeeService.execute();

			} catch (IllegalInputException e) {
				System.out.println(e.getIllegalInputMessage());
				System.out.println();
				continue;
			} catch (SystemErrorException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				break;
			}
		} while (endCheck);
		consoleWriter.showSystemEnd();
	}
}
