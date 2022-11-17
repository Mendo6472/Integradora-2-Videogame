package model;

public class Player {

	private String nickname;
	private String name;
	private double score = 10;
	private int levelID = 1;
	private int lifes = 5;

	/**
	 * 
	 * @param nickname
	 * @param name
	 */
	public Player(String nickname, String name) {
		this.nickname = nickname;
		this.name = name;
	}

	public String getNickname() {
		return this.nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return this.score;
	}

	/**
	 * 
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	public int getLifes() {
		return this.lifes;
	}

	/**
	 * 
	 * @param lifes
	 */
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public int getLevelID() {
		return this.levelID;
	}

	/**
	 * 
	 * @param levelID
	 */
	public void setLevelID(int levelID) {
		this.levelID = levelID;
	}

}