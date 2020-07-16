/**
 *
 */
import java.util.HashMap;
import java.util.Map;

/**
 * @author misak
 */
/**
 * 電話帳みたいな個人情報を扱うクラス。
 */
public class PersonalData {
	/**
	 * infoはユーザーで関連付けられた個人情報をマップで管理します。
	 *
	 */
	private Map<String, String> info;

	/**
	 * ユーザーをキーにしてユーザーごとのデータを管理します。
	 */
	//<user <K, V>> K:categoly, V:categolyに紐づけられたデータ
	private Map<String, Map<String, String>> personal;

	/**
	 * ユーザーの保有するデータを管理するクラスを作成します
	 * @param user ユーザー
	 */
	public PersonalData(String user) {
		info = new HashMap<>();
		personal = new HashMap<>();
		personal.put(user, info);
	}

	/**
	 * 指定された要素が見つからないときにエラーメッセージを表示します。
	 * @return エラーメッセージ
	 * @throws NoSuchElementException NoSuchElementExceptionをスローします。
	 */
	public String errorMsg() throws NoSuchElementException {
		throw new NoSuchElementException("指定された要素は存在しません");
	}

	/**
	 * @param key データのカテゴリキー
	 * @return info キーに関連付けられたデータ
	 * @throws NoSuchElementException NoSuchElementExceptionをスローします。
	 * keyで関連付けられているデータを返します。
	 */
	public String getInfo(String key) throws NoSuchElementException {
		if(info.containsKey(key)) {
			return info.get(key);
		}else {
			return errorMsg();
		}
	}

	/**
	 * @param key カテゴリー
	 * @param in  keyに関連付けて追加したい情報
	 * userで関連付けられたカテゴリー情報を追加します。
	 */
	public void addInfo(String key, String in) {
		info.put(key, in);
	}

	/**
	 * @return personal
	 */
	public Map<String, Map<String, String>> getPersonal() {
		return this.personal;
	}
}
