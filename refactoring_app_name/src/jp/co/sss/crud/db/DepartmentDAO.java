package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.util.ConstantSQL;

public class DepartmentDAO {

	/** インスタンス化を禁止 */
	private DepartmentDAO() {
	}

	/**
	 * 全ての部署情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 */
	public static List<Department> findAllDepartment() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT＿DEPT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				return null;
			}

			List<Department> deptList = new ArrayList<>();

			// レコードを出力
			while (resultSet.next()) {
				Department department = new Department();
				department.setDeptId(Integer.parseInt(resultSet.getString("dept_id")));
				department.setDeptName(resultSet.getString("dept_name"));

				deptList.add(department);
			}

			return deptList;

		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}
}
