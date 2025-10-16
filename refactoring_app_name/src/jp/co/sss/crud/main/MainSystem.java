package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeService;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 * コミット＆プッシュテスト
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
		EmployeeService employeeService = new EmployeeService();

		boolean endCheck = true;

		do {
			try {//メニューの表示
				consoleWriter.showMenu();

				//メニュー番号の入力
				String menuNo = menuNoReader.input();

				// 機能の呼出
				endCheck = employeeService.execute(menuNo);
				/**switch (menuNo) {
				case 1:
					// 全件表示機能の呼出
					EmployeeDAO.findAllEmployee();
					break;
				
				case 2:
					// 社員名検索
					System.out.print("社員名:");
				
					// 検索機能の呼出
					EmployeeDAO.findEmployeeByName();
					break;
				
				case 3:
					// 検索する部署IDを入力
					System.out.print("部署ID(1:営業部、2:経理部、3:総務部)を入力してください:");
					String inputDeptId = br.readLine();
				
					// 検索機能の呼出
					EmployeeDAO.findEmployeesByDeptId(inputDeptId);
					break;
				
				case 4:
					// 登録する値を入力
					System.out.print("社員名:");
					String empName = br.readLine();
					System.out.print("性別(0:その他, 1:男性, 2:女性, 9:回答なし):");
					String gender = br.readLine();
					System.out.print("生年月日(西暦年/月/日):");
					String birthday = br.readLine();
					System.out.print("部署ID(1:営業部、2:経理部、3:総務部):");
					String deptId = br.readLine();
				
					// 登録機能の呼出
					EmployeeDAO.insertEmployee(empName, gender, birthday, deptId);
					break;
				
				case 5:
					// 更新する社員IDを入力
					System.out.print("更新する社員の社員IDを入力してください：");
				
					// 更新する値を入力する
					String inputEmpId = br.readLine();
					Integer.parseInt(inputEmpId);
				
					// 更新機能の呼出
					EmployeeDAO.updateEmployeeById(inputEmpId);
					System.out.println("社員情報を更新しました");
				
					break;
				
				case 6:
					// 削除する社員IDを入力
					System.out.print("削除する社員の社員IDを入力してください：");
				
					// 削除機能の呼出
					EmployeeDAO.deleteEmployeeById();
					break;
				
				}*/
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
