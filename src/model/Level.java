package model;

public class Level {

	private int levelID;
	private double requiredScoreForNextLevel;
	private int treasureAmmount;
	private int enemiesAmmount;
	private String difficultyLevel;
	private Enemy[] enemies;
	private Treasure[] treasures;

	/**
	 * 
	 * @param levelID
	 * @param requiredScoreForNextLevel
	 * @param treasureAmmount
	 */
	public Level(int levelID, double requiredScoreForNextLevel, int treasureAmmount, int enemiesAmmount, int difficultyLevel) {
		this.levelID = levelID;
		this.requiredScoreForNextLevel = requiredScoreForNextLevel;
		this.treasureAmmount = treasureAmmount;
		this.enemiesAmmount = enemiesAmmount;
		this.enemies = new Enemy[enemiesAmmount];
		this.treasures = new Treasure[treasureAmmount];
		switch(difficultyLevel){
			case 1:
				this.difficultyLevel = "bajo";
			break;

			case 2:
				this.difficultyLevel = "medio";
			break;

			case 3:
				this.difficultyLevel = "alto";
			break;
		}
	}
	
	/**
	 * @param VERTICAL_RESOLUTION
	 * @param HORIZONTAL_RESOLUTION
	 * @param nameId
	 * @param type
	 * @param lostPoints
	 * @param winPoints
	 * @return
	 */
	public String registerEnemy(int VERTICAL_RESOLUTION, int HORIZONTAL_RESOLUTION, String nameId, int type, double lostPoints, double winPoints){
		String msj = "Cantidad maxima de enemigos alcanzada";
		boolean added = false;
		for(int i = 0; i < enemiesAmmount && !added; i++){
			if(enemies[i]==null){
				Enemy enemy = new Enemy(VERTICAL_RESOLUTION, HORIZONTAL_RESOLUTION, nameId, type, lostPoints, winPoints);
				enemies[i] = enemy;
				added = true;
				msj = "Enemigo añadido con exito";
			}
		}
		return msj;
	}

	/**
	 * @param VERTICAL_RESOLUTION
	 * @param HORIZONTAL_RESOLUTION
	 * @param nameId
	 * @param url
	 * @param scoreGranted
	 * @return
	 */
	public String registerTreasure(int VERTICAL_RESOLUTION, int HORIZONTAL_RESOLUTION, String nameId, String url, double scoreGranted){
		String msj = "Cantidad maxima de tesoros alcanzada";
		boolean added = false;
		for(int i = 0; i < treasureAmmount && !added; i++){
			if(treasures[i]==null){
				Treasure treasure = new Treasure(VERTICAL_RESOLUTION, HORIZONTAL_RESOLUTION, nameId, url, scoreGranted);
				treasures[i] = treasure;
				added = true;
				msj = "Tesoro añadido con exito";
			}
		}
		return msj;
	}

	/**
	 * @param nameId
	 * @return
	 */
	public int searchEnemyPos(String nameId){
		int pos = -1;
		boolean found = false;
		for(int i = 0; i < enemiesAmmount && !found; i++){
			if(enemies[i] != null){
				if(enemies[i].getNameID().equals(nameId)){
					pos = i;
					found = true;
				}
			}
		}
		return pos;
	}

	/**
	 * @param nameId
	 * @return
	 */
	public int searchTreasurePos(String nameId){
		int pos = -1;
		boolean found = false;
		for(int i = 0; i < treasureAmmount && !found; i++){
			if(treasures[i] != null){
				if(treasures[i].getName().equals(nameId)){
					pos = i;
					found = true;
				}
			}
		}
		return pos;
	}

	/**
	 * @return
	 */
	public String informTreasuresAndEnemies(){
		String msj = "----------Tesoros----------\n";
		for(int i = 0; i < treasureAmmount; i++){
			if(treasures[i] != null){
				msj += treasures[i].toString();
			}
		}
		msj += "----------Enemigos----------\n";
		for(int i = 0; i < enemiesAmmount; i++){
			if(enemies[i] != null){
				msj += enemies[i].toString();
			}
		}
		return msj;
	}

	/**
	 * @param name
	 * @return
	 */
	public int informQuantityOfTreasure(String name){
		int quantity = 0;
		for(int i = 0; i < treasureAmmount; i++){
			if(treasures[i] != null){
				if(treasures[i].getName().toLowerCase().equals(name)){
					quantity += 1;
				}
			}
		}
		return quantity;
	}

	/**
	 * @param type
	 * @return
	 */
	public int informQuantityOfEnemyType(int type){
		int ammount = 0;
		EnemyType enemyType;
		switch(type){
			case 1 -> enemyType = EnemyType.OGRE;
			case 2 -> enemyType = EnemyType.ABSTRACT;
			case 3 -> enemyType = EnemyType.BOSS;
			default -> enemyType = EnemyType.MAGIC; //case 4
		}
		for(int i = 0; i < enemiesAmmount; i++){
			if(enemies[i] != null){
				if(enemies[i].getType() == enemyType){
					ammount += 1;
				}
			}
		}
		return ammount;
	}
	
	/**
	 * @return
	 */
	public String[] informEnemyThatGivesMostScore(){
		String[] enemy = new String[2];
		double mostPoints = 0;
		for(int i = 0; i < enemiesAmmount; i++){
			if(enemies[i] != null){
				if(enemies[i].getWinPoints() > mostPoints){
					mostPoints = enemies[i].getWinPoints();
					enemy[0] = enemies[i].getNameID();
				}
			}
		}
		enemy[1] = String.valueOf(mostPoints);
		return enemy;
	}

	/**
	 * @return
	 */
	public int informConsonantsOfEnemies(){
		int consonants = 0;
		String name;
		for(int i = 0; i < enemiesAmmount; i++){
			if(enemies[i] != null){
				name = enemies[i].getNameID();
				for (int j=0 ; j<name.length(); j++){
					char ch = name.charAt(j);
					if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
					   //nothing
					}else if(ch != ' '){
					   consonants++;
					}
				 }
			}
		}

		return consonants;
	}


	/**
	 * @return
	 */
	public Treasure[] getTreasures() {
		return treasures;
	}

	/**
	 * @return
	 */
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

	/**
	 * @return
	 */
	public double getRequiredPointsForNextLevel() {
		return requiredScoreForNextLevel;
	}


	/**
	 * @return
	 */
	public int getTreasureAmmount() {
		return this.treasureAmmount;
	}

	/**
	 * 
	 * @param treasureAmmount
	 */
	public void setTreasureAmmount(int treasureAmmount) {
		this.treasureAmmount = treasureAmmount;
	}

	/**
	 * @return
	 */
	public String getDifficultyLevel() {
		return this.difficultyLevel;
	}

	/**
	 * 
	 * @param difficultyLevel
	 */
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

}