package jp.co.sss.crud.util;

public enum Gender {
	NO_ANSWER("回答なし", "0"), MALE("男性", "1"), FEMALE("女性", "2"), OTHER("その他", "9");

	private final String japanese;
	private final String number;

	Gender(String japanese, String number) {
		this.japanese = japanese;
		this.number = number;
	}

	@Override
	public String toString() {
		return japanese;
	}

	public String getNumber() {
		return this.number;
	}

	/**
	 * 数字を元に該当の性別enumを取得
	 * @param number
	 * @return Gender
	 */
	public static Gender fromNumeric(String number) {
		return switch (number) {
		case "0" -> NO_ANSWER;
		case "1" -> MALE;
		case "2" -> FEMALE;
		case "9" -> OTHER;
		default -> null;
		};
	}
}
