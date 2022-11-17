package ui;

import java.util.Scanner;
import model.Videogame;

public class Main {

	private Scanner reader;
	private Videogame controller;

	public Main(){
		reader = new Scanner(System.in);
		controller = new Videogame();
	}

	public static void main(String[] args){
		Main main = new Main();
		int option = -1;
		do{
			main.showOptions();
			option = main.validateIntegerInput();
			main.selectOption(option);
		}while(option != 0);
	}

	public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
			reader.nextLine();
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	public void showOptions(){
		System.out.println("Bienvenido al videojuego, que desea hacer:\n" + 
						   "1. Registrar un jugador.\n" +
						   "2. Registrar enemigo a un nivel.\n" +
						   "3. Registrar tesoro a un nivel.\n" +
						   "4. Modificar el puntaje de un jugador.\n" +
						   "5. Incrementar nivel de jugador.\n" +
						   "6. Informar tesoros y enemigos de un nivel.\n" +
						   "7. Informar cantidad de un tesoro en los niveles.\n" +
						   "8. Informar cantidad de un tipo de enemigo en los niveles.\n" +
						   "9. Informar el tesoro mas repetido en los niveles.\n" +
						   "10. Informar el enemigo que mayor puntaje otorga.\n" +
						   "11. Informar cantidad de consonantes de los enemigos.\n" +
						   "12. Informar el top 5 de jugadores.\n" +
						   "0. Salir.\n");
	}

	public void selectOption(int option){
		switch(option){
			case 1 -> registerPlayer();

			case 2 -> registerEnemyToLevel();

			case 3 -> registerTreasureToLevel();

			case 4 -> modifyScoreOfPlayer();

			case 5 -> levelUpPlayer();

			case 6 -> informTreasuresAndEnemies();

			case 7 -> informQuantityOfTreasure();

			case 8 -> informQuantityOfEnemyType();

			case 9 -> informMostRepeatedTreasure();

			case 10 -> informEnemyThatGivesMostScore();

			case 11 -> informConsonantsOfEnemies();

			case 12 -> informTopFivePlayers();

			case 0 -> System.out.println("Exit program.");

			default -> System.out.println("Wrong choice");


		}
	}

	public void registerPlayer() {
		String nickname;
		String name;
		System.out.println("Ingrese el nickname");
		nickname = reader.nextLine();
		System.out.println("Ingrese el nombre");
		name = reader.nextLine();
		System.out.println(controller.registerPlayer(nickname, name));
	}

	public void registerEnemyToLevel(){
		int levelPos;
		String nameId;
		int type;
		double lostPoints;
		double winPoints;
		System.out.println("Ingrese el id del nivel");
		levelPos = (validateIntegerInput()-1);
		System.out.println("Ingrese el nombre de enemigo");
		nameId = reader.nextLine();
		System.out.println("Ingrese el tipo de enemigo (int)\n" + 
						   "1. Ogro\n" +
						   "2. Abstracto\n" +
						   "3. Jefe\n" +
						   "4. Magico");
		type = validateIntegerInput();
		System.out.println("Ingrese los puntos que pierde el jugador al ser derrotado por este enemigo.");
		lostPoints = reader.nextDouble();
		System.out.println("Ingrese los puntos que gana el jugador al derrotar al enemigo.");
		winPoints = reader.nextDouble();
		System.out.println(controller.registerEnemyToLevel(levelPos, nameId, type, lostPoints, winPoints));
	}

	public void registerTreasureToLevel() {
		int levelPos;
		String nameId;
		String url;
		double scoreGranted;
		System.out.println("Ingrese el id del nivel");
		levelPos = (validateIntegerInput()-1);
		System.out.println("Ingrese el nombre del tesoro");
		nameId = reader.nextLine();
		System.out.println("Ingrese la url de la imagen del tesoro");
		url = reader.nextLine();
		System.out.println("Ingrese la cantidad de puntaje que se otorga al jugador al encontrarlo");
		scoreGranted = reader.nextDouble();
		System.out.println(controller.registerTreasureToLevel(levelPos, nameId, url, scoreGranted));
	}

	public void modifyScoreOfPlayer(){
		String nickname;
		double score;
		System.out.println("Ingrese el nickname del jugador");
		nickname = reader.nextLine();
		System.out.println("Ingrese el puntaje");
		score = reader.nextDouble();
		System.out.println(controller.modifyScoreOfPlayer(nickname, score));
	}

	public void levelUpPlayer(){
		String nickname;
		System.out.println("Ingrese el nickname del jugador");
		nickname = reader.nextLine();
		System.out.println(controller.levelUpPlayer(nickname));
	}

	public void informTreasuresAndEnemies(){
		int levelPos;
		System.out.println("Ingrese el ID del level");
		levelPos = validateIntegerInput() - 1;
		System.out.println(controller.informTreasuresAndEnemies(levelPos));
	}

	public void informQuantityOfTreasure(){
		String name;
		System.out.println("Ingrese el nombre del tesoro a buscar");
		name = reader.nextLine();
		System.out.println(controller.informQuantityOfTreasure(name));
	}

	public void informQuantityOfEnemyType(){
		int type;
		System.out.println("Ingrese el tipo de enemigo (int)\n" + 
		"1. Ogro\n" +
		"2. Abstracto\n" +
		"3. Jefe\n" +
		"4. Magico");
		type = validateIntegerInput();
		System.out.println(controller.informQuantityOfEnemyType(type));
	}

	public void informMostRepeatedTreasure(){
		System.out.println(controller.informMostRepeatedTreasure());
	}

	public void informEnemyThatGivesMostScore(){
		System.out.println(controller.informEnemyThatGivesMostScore());
	}

	public void informConsonantsOfEnemies(){
		System.out.println(controller.informConsonantsOfEnemies());
	}

	public void informTopFivePlayers(){
		System.out.println(controller.informTopFivePlayers());
	}
}
