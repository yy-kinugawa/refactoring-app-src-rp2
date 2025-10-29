package jp.co.sss.crud.db;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;

public interface IEmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public List<Employee> findAllEmployee() throws SystemErrorException, IllegalInputException;

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @param String 検索ワード
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public List<Employee> findEmployeeByName(String searchWord)
			throws SystemErrorException, IllegalInputException;

	/**
	 * 部署IDに該当する社員情報を検索
	 * 
	 * @param String 部署ID
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public List<Employee> findEmployeesByDeptId(String inputDeptId)
			throws SystemErrorException, IllegalInputException;

	/**
	 * 社員情報を1件登録
	 * 
	 * @param Employee
	 * @throws SystemErrorException 
	 * @throws IllegalInputException           
	 */
	public int insertEmployee(Employee employee) throws SystemErrorException, IllegalInputException;

	/**
	 * 社員情報を1件更新
	 * 
	 * @param Employee
	 * @throws SystemErrorException 
	 * @throws IllegalInputException   
	 */
	public int updateEmployeeById(Employee employee) throws SystemErrorException, IllegalInputException;

	/**
	 * 社員情報を1件削除
	 *
	 * @param String 社員ID
	 * @throws SystemErrorException 
	 * @throws IllegalInputException   
	 */
	public int deleteEmployeeById(String empId) throws SystemErrorException, IllegalInputException;

}
