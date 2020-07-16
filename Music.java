import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Musicを管理するクラスです。
 * @author misak
 *
 */

public class Music  implements IPlay{
	/**
	 * アーティスト
	 */
	private String artist;

	/**
	 * musicリストを表します。<br>曲名で管理します。
	 */
	private List<String> music;
	/**
	 * アーティストをキーにして、アルバムのような感じで曲名を管理します。
	 */
	private Map<String, List<String>> musiclist;
	private Scanner sc;

	/**
	 * musicリストを作成します。
	 */
	public Music() {
		music = new ArrayList<>();
		musiclist = new HashMap<>();
	}

	/**
	 * artを引数にして、Musicリストを作成します。
	 * @param art アーティスト
	 */
	public Music(String art) {
		this.artist = art;
		music = new ArrayList<>();
		musiclist = new HashMap<>();
		musiclist.put(art, music);
	}

	/**
	 * Musicリストに引数で指定した曲を追加します。
	 * @param music 曲名
	 */
	//musicの追加のみ
	public void addMusic(String music) {
		this.music.add(music);
	}

	/*
	 * musicリストを作成します。(artistを指定しないでオブジェクト作成したとき用)
	 * @param art アーティスト
	 */
	//musicList作成
	public void createMusic(String art) {
		this.artist = art;
		musiclist.put(art, music);
		sc = new Scanner(System.in);
		boolean insert = true;
		System.out.println(
				"Musicリストを作成します。endが入力されたら操作を終了します。"
				+ "\n-----------------------入力開始----------------------");
		while (insert) {
			String music = sc.next();
			if (music.equalsIgnoreCase("end"))
				insert = false;
			else
				this.music.add(music);
		}
		System.out.println(
				"--------------------------入力終了---------------------"
				+"\nリストができました");
	}

	/**
	 * 曲名を取得します。
	 * @param num 再生したい曲の順番
	 * @return 指定された順番にある曲名
	 */
	public String getMusic(String num) {
		return music.get(Integer.parseInt(num) - 1);
	}

	/**
	 * 音楽を再生します()
	 */
	@Override
	public void play() {
		System.out.println("音楽を再生します");
	}

	/**
	 * 指定された順番の曲を再生します。
	 */
	@Override
	public void play(int num) {
		System.out.println(music.get(num - 1) + "を再生します");
	}

	/**
	 * 音楽を停止します。
	 */
	@Override
	public void stop() {
		System.out.println("音楽を停止します");
	}

	/**
	 * 音楽を一時停止します。
	 */
	@Override
	public void pause() {
		System.out.println("音楽を一時停止します");
	}
}
