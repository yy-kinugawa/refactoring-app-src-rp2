package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class EmployeeDAO implements IEmployeeDAO {

	private static final EmployeeDAO EMPLOYEE_DAO = new EmployeeDAO();

	/** インスタンス化を禁止 */
	private EmployeeDAO() {
	}

	/**
	 * インスタンス生成
	 * @return EmpyeeDAO
	 */

	public static EmployeeDAO getInstance() {
		return EMPLOYEE_DAO;
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public List<Employee> findAllEmployee() throws SystemErrorException, IllegalInputException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				throw new IllegalInputException();
			}

			List<Employee> employees = new ArrayList<>();

			// レコードを出力
			while (resultSet.next()) {
				Employee ones = new Employee();
				ones.setEmpId(resultSet.getString("emp_id"));
				ones.setEmpName(resultSet.getString("emp_name"));
				ones.setGender(resultSet.getString("gender"));
				ones.setBirthday(resultSet.getString("birthday"));
				ones.setDeptName(resultSet.getString("dept_name"));

				employees.add(ones);
			}

			return employees;

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.GET_DATA_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException(ConstantMsg.NO_EMPLOYEE);
		} finally {
			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @param String 検索ワード
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public List<Employee> findEmployeeByName(String searchWord)
			throws SystemErrorException, IllegalInputException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			List<Employee> employees = new ArrayList<>();

			// レコードを出力
			while (resultSet.next()) {
				Employee ones = new Employee();
				ones.setEmpId(resultSet.getString("emp_id"));
				ones.setEmpName(resultSet.getString("emp_name"));
				ones.setGender(resultSet.getString("gender"));
				ones.setBirthday(resultSet.getString("birthday"));
				ones.setDeptName(resultSet.getString("dept_name"));

				employees.add(ones);
			}

			return employees;

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.GET_DATA_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException(ConstantMsg.NO_EMPLOYEE);
		} finally {
			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 * 
	 * @param String 部署ID
	 * @throws SystemErrorException 
	 * @throws IllegalInputException 
	 */
	public List<Employee> findEmployeesByDeptId(String inputDeptId)
			throws SystemErrorException, IllegalInputException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(inputDeptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			List<Employee> employees = new ArrayList<>();

			// レコードを出力
			while (resultSet.next()) {
				Employee ones = new Employee();
				ones.setEmpId(resultSet.getString("emp_id"));
				ones.setEmpName(resultSet.getString("emp_name"));
				ones.setGender(resultSet.getString("gender"));
				ones.setBirthday(resultSet.getString("birthday"));
				ones.setDeptName(resultSet.getString("dept_name"));

				employees.add(ones);
			}

			return employees;

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.GET_DATA_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException(ConstantMsg.NO_EMPLOYEE);
		} finally {
			try {
				// ResultSetをクローズ
				DBManager.close(resultSet);
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param Employee
	 * @throws SystemErrorException 
	 * @throws IllegalInputException           
	 */
	public int insertEmployee(Employee employee) throws SystemErrorException, IllegalInputException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, Integer.parseInt(employee.getGender()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(employee.getDeptId()));

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(ConstantMsg.GET_DATA_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException(ConstantMsg.NO_EMPLOYEE);
		} finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param Employee
	 * @throws SystemErrorException 
	 * @throws IllegalInputException   
	 */
	public int updateEmployeeById(Employee employee) throws SystemErrorException, IllegalInputException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, Integer.parseInt(employee.getGender()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, Integer.parseInt(employee.getDeptId()));
			preparedStatement.setInt(5, Integer.parseInt(employee.getEmpId()));

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(ConstantMsg.GET_DATA_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException(ConstantMsg.NO_EMPLOYEE);
		} finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @param String 社員ID
	 * @throws SystemErrorException 
	 * @throws IllegalInputException   
	 */
	public int deleteEmployeeById(String empId) throws SystemErrorException, IllegalInputException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.GET_DATA_ERROR, e);
		} catch (IllegalInputException e) {
			throw new IllegalInputException(ConstantMsg.NO_EMPLOYEE);
		} finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
