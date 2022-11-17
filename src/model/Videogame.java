package model;

public class Videogame {

	public final int HORIZONTAL_RESOLUTION = 1280;
	public final int VERTICAL_RESOLUTION = 720;
	public final int MAX_PLAYERS = 20;
	public final int MAX_LEVELS = 10;
	private Player[] players;
	private Level[] levels;

	public Videogame() {
		this.players = new Player[MAX_PLAYERS];
		this.levels = new Level[MAX_LEVELS];
		levels[0] = new Level(1, 10, 1, 1, 1);
		levels[1] = new Level(2, 20, 2, 1, 1);
		levels[2] = new Level(3, 30, 2, 1, 1);
		levels[3] = new Level(4, 40, 2, 1, 2);
		levels[4] = new Level(5, 50, 2, 2, 2);
		levels[5] = new Level(6, 60, 3, 2, 2);
		levels[6] = new Level(7, 70, 5, 3, 2);
		levels[7] = new Level(8, 80, 8, 4, 3);
		levels[8] = new Level(9, 90, 10, 5, 3);
		levels[9] = new Level(10, 100, 15, 5, 3);
	}

	/**
	 * @param nickname
	 * @param name
	 * @return
	 */
	public String registerPlayer(String nickname, String name) {
		String msj = "Capacidad maxima de jugadores alcanzada.";
		boolean added = false;
		if(searchNicknamePos(nickname) != -1){
			return msj = "Un jugador con ese nickname ya existe";
		}
		for(int i = 0; i<MAX_PLAYERS && !added; i++){
			if(players[i] == null){
				Player player = new Player(nickname, name);
				players[i] = player;
				added = true;
				msj = "Jugador añadido con exito";
			}
		}
		return msj;
	}
	
	/**
	 * @param levelPos
	 * @param nameId
	 * @param type
	 * @param lostPoints
	 * @param winPoints
	 * @return
	 */
	public String registerEnemyToLevel(int levelPos, String nameId, int type, double lostPoints, double winPoints){
		String msj = "Capacidad maxima de enemigos alcanzada";
		if(levelPos > 9 | levelPos < 0){
			return msj = "Ese nivel no existe";
		}
		if(searchEnemyPos(levelPos, nameId) != -1){
			return msj = "Un enemigo con ese nombre ya existe en el nivel";
		}
		msj = levels[levelPos].registerEnemy(VERTICAL_RESOLUTION, HORIZONTAL_RESOLUTION, nameId, type, lostPoints, winPoints);
		return msj;
	}

	/**
	 * @param levelPos
	 * @param nameId
	 * @param url
	 * @param scoreGranted
	 * @return
	 */
	public String registerTreasureToLevel(int levelPos, String nameId, String url, double scoreGranted){
		String msj = "Capacidad maxima de tesoros alcanzada";
		if(levelPos > 9 | levelPos < 0){
			return msj = "Ese nivel no existe";
		}
		if(searchTreasurePos(levelPos, nameId) != -1){
			return msj = "Un tesoro con ese nombre ya existe en el nivel";
		}
		msj = levels[levelPos].registerTreasure(VERTICAL_RESOLUTION, HORIZONTAL_RESOLUTION, nameId, url, scoreGranted);
		return msj;
	}

	/**
	 * @param nickname
	 * @param score
	 * @return
	 */
	public String modifyScoreOfPlayer(String nickname, double score){
		String msj = "Puntaje modificado con exito";
		int userPos = searchNicknamePos(nickname);
		if(userPos == -1){
			return msj = "Ese jugador no existe";
		}
		players[userPos].setScore(score);
		return msj;
	}

	/**
	 * @param nickname
	 * @return
	 */
	public String levelUpPlayer(String nickname){
		String msj = "";
		int userPos = searchNicknamePos(nickname);
		if(userPos == -1){
			return msj = "Ese usuario no existe";
		}
		int levelPos = players[userPos].getLevelID() -1;
		double score = players[userPos].getScore();
		double requiredScore = levels[levelPos].getRequiredPointsForNextLevel();
		if(score >= requiredScore){
			msj = "Ha subido de nivel";
			players[userPos].setLevelID(levelPos+2);
		} else {
			msj = "No tiene suficientes puntos para subir de nivel, necesitas " + (requiredScore - score) + " puntos mas.";
		}
		
		return msj;
	}


	/**
	 * @param levelPos
	 * @param nameId
	 * @return
	 */
	public int searchEnemyPos(int levelPos, String nameId){
		int pos = levels[levelPos].searchEnemyPos(nameId);
		return pos;
	}

	/**
	 * @param levelPos
	 * @param nameId
	 * @return
	 */
	public int searchTreasurePos(int levelPos, String nameId){
		int pos = levels[levelPos].searchTreasurePos(nameId);
		return pos;
	}
	
	/**
	 * @param levelPos
	 * @return
	 */
	public String informTreasuresAndEnemies(int levelPos){
		String msj = "";
		if(levelPos > 9 | levelPos < 0){
			return msj = "Nivel incorrecto";
		}
		msj = levels[levelPos].informTreasuresAndEnemies();
		return msj;
	}

	/**
	 * @param name
	 * @return
	 */
	public String informQuantityOfTreasure(String name){
		name = name.toLowerCase();
		String msj = "";
		int treasureAmmount = 0;
		for(int i = 0; i < MAX_LEVELS;i++){
			treasureAmmount += levels[i].informQuantityOfTreasure(name);
		}
		msj = "En total hay " + treasureAmmount;
		return msj;
	}

	/**
	 * @param type
	 * @return
	 */
	public String informQuantityOfEnemyType(int type){
		String msj = "";
		int enemyTypeAmmount = 0;
		if(type > 4 | type < 1){
			return msj = "Tipo incorrecto";
		}
		for(int i = 0; i < MAX_LEVELS; i++){
			enemyTypeAmmount += levels[i].informQuantityOfEnemyType(type);
		}
		msj = "En total hay " + enemyTypeAmmount;
		return msj;
	}

	/**
	 * @return
	 */
	public String informMostRepeatedTreasure(){
		String msj = "this is dumb";
		String[] names = new String[50];
		int[] ammount = new int[50];
		for(int i = 0; i < MAX_LEVELS; i++){
			Treasure[] treasures = levels[i].getTreasures();
			for(int j = 0; j < treasures.length; j++){
				if(treasures[j] != null){
					boolean found = false;
					for(int k = 0; k < names.length && !found; k++){
						if(names[k]!=null){
							if(treasures[j].getName().toLowerCase().equals(names[k])){
								found = true;
								ammount[k] += 1;
							}
						}
					}
					if(found == false){
						boolean added = false;
						for(int k = 0; k < names.length && !added;k++){
							if(names[k]==null){
								names[k] = treasures[j].getName();
								ammount[k] = 1;
								added = true;
							}
						}
					}
				}
			}
		}
		int mostRepeatedTreasurePos = -1;
		int mostRepeatedTreasureAmmount = 0;
		for(int i = 0; i < 50; i++){
			if(ammount[i] > mostRepeatedTreasureAmmount){
				mostRepeatedTreasureAmmount = ammount[i];
				mostRepeatedTreasurePos = i;

			}
		}
		if(mostRepeatedTreasurePos == -1){
			return msj = "No hay tesoros.";
		}
		msj = "El tesoro mas repetido es " + names[mostRepeatedTreasurePos] + ", se repitio un total de " + mostRepeatedTreasureAmmount + "veces";
		return msj;
	}

	/**
	 * @return
	 */
	public String informEnemyThatGivesMostScore(){
		String msj = "";
		String[] enemies = new String[MAX_LEVELS];
		double[] score = new double[MAX_LEVELS];
		for(int i = 0; i < MAX_LEVELS; i++){
			enemies[i] = levels[i].informEnemyThatGivesMostScore()[0];
			score[i] = Double.valueOf(levels[i].informEnemyThatGivesMostScore()[1]);
		}
		double maxScore = 0;
		int maxScorePos = -1;
		for(int i = 0; i < MAX_LEVELS; i++){
			if(score[i] > maxScore){
				maxScore = score[i];
				maxScorePos = i;
			}
		}
		if(maxScorePos == -1){
			return msj = "No hay enemigos";
		}
		msj = "El enemigo que mas puntaje otorga ("+maxScore+") es el enemigo " + enemies[maxScorePos] + ", se encuentra en el nivel " + (maxScorePos+1);
		return msj;
	}

	/**
	 * @return
	 */
	public String informConsonantsOfEnemies(){
		String msj = "";
		int consonants = 0;
		for(int i = 0; i < MAX_LEVELS; i++){
			consonants += levels[i].informConsonantsOfEnemies();
		}
		msj = "La cantidad total de consonantes de los nombres de los enemigos es: " + consonants;
		return msj;
	}

	/**
	 * @return
	 */
	public String informTopFivePlayers(){
		String msj = "Top | Nickname | Score\n";
		String[] names = new String[5];
		double[] scores = new double[5];
		double score;
		String name;
		int position;
		for(int i = 0; i < 5; i++){
			names[i] = "-----";
		}
		for(int i = 0; i < MAX_PLAYERS; i++){
			if(players[i]!=null){
				score = players[i].getScore();
				name = players[i].getNickname();
				position = -1;
				for(int j = 0; j < 5; j++){
					if(score > scores[j]){
						position = j;
					}
				}
				for(int j = 1; j <= position; j++){
					scores[j-1] = scores[j];
					names[j-1] = names[j];
				}
				if(position != -1){
					scores[position] = score;
					names[position] = name;
				}
			}
		}
		int top = 1;
		for(int i = 4; i>=0; i--){
			msj += top + " | " + names[i]+" | " + scores[i] + "\n";
			top++;
		}
		return msj;
	}

	/**
	 * @param nickname
	 * @return
	 */
	public int searchNicknamePos(String nickname){
		int pos = -1;
		boolean found = false;
		for(int i = 0; i < MAX_PLAYERS && !found; i++){
			if(players[i] != null){
				if(players[i].getNickname().equals(nickname)){
					pos = i;
					found = true;
				}
			}
		}
		return pos;
	}

}