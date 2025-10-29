package jp.co.sss.crud.util;

/**
 * 性別のenumクラス
 * 
 * @author 絹川
 */
public enum Menu {

	MENU_NO1("全件表示", "1"), MENU_NO2("社員名検索", "2"), MENU_NO3("部署ID検索", "3"), MENU_NO4("新規登録", "4"), MENU_NO5("更新",
			"5"), MENU_NO6("削除", "6"), MENU_NO7("終了", "7");

	//表記名
	private final String japanese;
	//No
	private final String number;

	Menu(String japanese, String number) {
		this.japanese = japanese;
		this.number = number;
	}

	@Override
	public String toString() {
		return number + "." + japanese;
	}
}
