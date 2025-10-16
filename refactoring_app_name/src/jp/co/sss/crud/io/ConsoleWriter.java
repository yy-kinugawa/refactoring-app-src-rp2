package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.db.DepartmentDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.Gender;

/**
 * コンソールの出力クラス
 * 
 * @author 絹川
 */

public class ConsoleWriter {

	/**
	 * メニュー表示 
	 */
	public void showMenu() {
		System.out.println(ConstantMsg.MENU_TITLE);
		//表示NOを設定
		int menuNum = 1;
		for (String str : ConstantMsg.MENU_LIST) {
			System.out.println(menuNum + "." + str);
			//次の表示NO
			menuNum++;
		}

		System.out.println(ConstantMsg.MENU_GUIDE);
	}

	/**
	 * 社員情報表示
	 * @param List<Employee>
	 */
	public void showEmployee(List<Employee> employees) {
		if (employees != null) {
			System.out.println(ConstantMsg.EMPLOYEE_ITEMS);
			for (Employee e : employees) {
				System.out.println(e);
			}
		} else {
			showNoEmployee();
		}
	}

	/**
	 * 社員名入力案内
	 */
	public void showInputEmployeeName() {
		System.out.print("社員名：");
	}

	/**
	 * 性別入力案内
	 */
	public void showInputEmployeeGender() {
		System.out.print("性別(");
		Gender[] genderList = Gender.values();
		for (int i = 0; i < genderList.length; i++) {
			System.out.print(genderList[i].getNumber() + ":" + genderList[i]);
			if (i < genderList.length - 1) {
				System.out.print(", ");
			} else {
				System.out.print("):");
			}
		}
	}

	/**
	 * 生年月日入力案内
	 */
	public void showInputEmployeeBirthday() {
		System.out.print("生年月日(西暦年/月/日):");
	}

	/**
	 * 部署ID入力表示
	 */
	public void showInputDeptId() throws SystemErrorException, IllegalInputException {
		List<Department> deptList = DepartmentDAO.findAllDepartment();
		System.out.print("部署ID(");
		for (int i = 0; i < deptList.size(); i++) {
			System.out.print((i + 1) + ":" + deptList.get(i).getDeptName());
			if (i < deptList.size() - 1) {
				System.out.print(", ");
			} else {
				System.out.print("):");
			}
		}
	}

	/**
	 * 社員ID入力案内(更新用)
	 */
	public void showInputEmpIdToUpdate() {
		System.out.print(ConstantMsg.UPDATE_GUIDE);
	}

	/**
	 * 社員ID入力案内(削除用)
	 */
	public void showInputEmpIdToDelete() {
		System.out.print(ConstantMsg.DELETE_GUIDE);
	}

	/**
	 * 社員新規登録完了通知
	 */
	public void showCompleteInsert() {
		System.out.println(ConstantMsg.COMP_INSERT);
	}

	/**
	 * 社員情報更新完了通知
	 */
	public void showCompleteUpdate() {
		System.out.println(ConstantMsg.COMP_UPDATE);
	}

	/**
	 * 社員情報削除完了通知
	 */
	public void showCompleteDelete() {
		System.out.println(ConstantMsg.COMP_DELETE);
	}

	/**
	 * システム終了案内
	 */
	public void showSystemEnd() {
		System.out.println(ConstantMsg.END_GUIDE);
	}

	/**
	 * 社員情報が無し
	 */
	public void showNoEmployee() {
		System.out.println(ConstantMsg.NO_EMPLOYEE);
	}
}
