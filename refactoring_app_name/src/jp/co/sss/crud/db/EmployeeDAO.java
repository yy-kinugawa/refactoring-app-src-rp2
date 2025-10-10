package jp.co.sss.crud.db;

import java.io.IOException;
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
import jp.co.sss.crud.util.ConstantSQL;

/**
 * DB操作処理用のクラス
 *
 * @author System Shared
 */
public class EmployeeDAO {

	/** インスタンス化を禁止 */
	private EmployeeDAO() {
	}

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findAllEmployee() throws ClassNotFoundException, SQLException, ParseException {
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
				return null;
			}

			List<Employee> employees = new ArrayList<>();

			// レコードを出力
			while (resultSet.next()) {
				Employee ones = new Employee();
				ones.setEmpId(Integer.parseInt(resultSet.getString("emp_id")));
				ones.setEmpName(resultSet.getString("emp_name"));
				ones.setGender(Integer.parseInt(resultSet.getString("gender")));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				ones.setBirthday(sdf.parse(resultSet.getString("birthday")));
				ones.setDeptName(resultSet.getString("dept_name"));

				employees.add(ones);
			}

			return employees;

		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findEmployeeByName(String searchWord)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

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
				ones.setEmpId(Integer.parseInt(resultSet.getString("emp_id")));
				ones.setEmpName(resultSet.getString("emp_name"));
				ones.setGender(Integer.parseInt(resultSet.getString("gender")));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				ones.setBirthday(sdf.parse(resultSet.getString("birthday")));
				ones.setDeptName(resultSet.getString("dept_name"));

				employees.add(ones);
			}

			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findEmployeesByDeptId(Integer inputDeptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

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
			preparedStatement.setInt(1, inputDeptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			List<Employee> employees = new ArrayList<>();

			// レコードを出力
			while (resultSet.next()) {
				Employee ones = new Employee();
				ones.setEmpId(Integer.parseInt(resultSet.getString("emp_id")));
				ones.setEmpName(resultSet.getString("emp_name"));
				ones.setGender(Integer.parseInt(resultSet.getString("gender")));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				ones.setBirthday(sdf.parse(resultSet.getString("birthday")));
				ones.setDeptName(resultSet.getString("dept_name"));

				employees.add(ones);
			}

			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static int insertEmployee(Employee employee)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			preparedStatement.setObject(3, employee.getBirthday(), Types.DATE);
			preparedStatement.setInt(4, employee.getDeptId());

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static int updateEmployeeById(Employee employee)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			preparedStatement.setObject(3, employee.getBirthday(), Types.DATE);
			preparedStatement.setInt(4, employee.getDeptId());
			preparedStatement.setInt(5, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static int deleteEmployeeById(Integer empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			return preparedStatement.executeUpdate();
		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}
}
