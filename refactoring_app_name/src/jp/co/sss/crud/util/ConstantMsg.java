package jp.co.sss.crud.util;

/**
 * メッセージをまとめたクラス(コンソール出力)
 * 
 * @author 絹川
 */

public class ConstantMsg {

	/** インスタンス化を禁止 */
	private ConstantMsg() {
	}

	/**
	 * 案内メッセージ
	 */
	/**タイトル*/
	public static final String MENU_TITLE = "=== 社員管理システム ===";
	/**メニュー項目*/
	public static final String[] MENU_LIST = {
			"全件表示",
			"社員名検索",
			"部署ID検索",
			"新規登録",
			"更新",
			"削除",
			"終了"
	};
	/**メニュー入力*/
	public static final String MENU_GUIDE = "メニュー番号を入力してください：";
	/**社員情報項目*/
	public static final String EMPLOYEE_ITEMS = "社員ID\t社員名\t性別\t生年月日\t部署名";
	/**更新入力*/
	public static final String UPDATE_GUIDE = "更新する社員の社員IDを入力してください：";
	/**削除入力*/
	public static final String DELETE_GUIDE = "削除する社員の社員IDを入力してください：";
	/**システム終了*/
	public static final String END_GUIDE = "システムを終了します。";

	/**
	 * エラーメッセージ
	 */
	/**非該当*/
	public static final String NO_EMPLOYEE = "該当者はいませんでした";
	/**半角数字入力*/
	public static final String NUMBER_VALIDATION = "半角数字で入力してください";
	/**30文字制限*/
	public static final String SIZE_VALIDATION = "30文字以内で入力してください";
	/**範囲指定*/
	public static final String RANGE_VALIDATION = " のいずれかを入力してください";
	/**日付形式*/
	public static final String DATE_VALIDATION = "(yyyy/mm/dd)の形式で入力してください";
	/**検索*/
	public static final String ERROR_SELECT = "社員情報の検索に失敗しました";
	/**登録*/
	public static final String ERROR_INSERT = "社員情報の登録に失敗しました";
	/**更新*/
	public static final String ERROR_UPDATE = "社員情報の更新に失敗しました";
	/**削除*/
	public static final String ERROR_DELETE = "社員情報の削除に失敗しました";

	/**
	 * 完了メッセージ
	 */
	/**登録*/
	public static final String COMP_INSERT = "社員情報を登録しました";
	/**更新*/
	public static final String COMP_UPDATE = "社員情報を更新しました";
	/**削除*/
	public static final String COMP_DELETE = "社員情報を削除しました";

}
