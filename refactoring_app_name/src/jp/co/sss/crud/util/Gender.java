package jp.co.sss.crud.util;

public enum Gender {
	NO_ANSWER("回答なし"), MALE("男性"), FEMALE("女性"), OTHER("その他");

	private final String japanese;;

	Gender(String japanese) {
		this.japanese = japanese;
	}

	@Override
	public String toString() {
		return japanese;
	}

	/**
	 * 数字を元に該当の性別enumを取得
	 * @param number
	 * @return Gender
	 */
	public static Gender fromNumeric(int number) {
		return switch (number) {
		case 0 -> NO_ANSWER;
		case 1 -> MALE;
		case 2 -> FEMALE;
		case 9 -> OTHER;
		default -> null;
		};
	}
}
