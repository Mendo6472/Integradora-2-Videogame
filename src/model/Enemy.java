package model;
import java.util.Random;

public class Enemy {
    private int VERTICAL_RESOLUTION;
    private int HORIZONTAL_RESOLUTION;
    private String nameID;
    private EnemyType type;
    private String typeString;
    private double lostPoints;
    private double winPoints;
    private int XPosition;
    private int YPosition;
    private Random random;

    public Enemy(int VERTICAL_RESOLUTION, int HORIZONTAL_RESOLUTION, String nameID, int type, double lostPoints, double winPoints){
        this.random = new Random();
        this.VERTICAL_RESOLUTION = VERTICAL_RESOLUTION;
        this.HORIZONTAL_RESOLUTION = HORIZONTAL_RESOLUTION;
        this.nameID = nameID;
        this.lostPoints = lostPoints;
        this.winPoints = winPoints;
        this.XPosition = random.nextInt(this.HORIZONTAL_RESOLUTION);
        this.YPosition = random.nextInt(this.VERTICAL_RESOLUTION);
        switch(type){
            case 1:
                this.type = EnemyType.OGRE;
                this.typeString = "Ogro";
            break;

            case 2:
                this.type = EnemyType.ABSTRACT;
                this.typeString = "Abstracto";
            break;

            case 3:
                this.type = EnemyType.BOSS;
                this.typeString = "Jefe";
            break;

            case 4:
                this.type = EnemyType.MAGIC;
                this.typeString = "Magico";
            break;
        }
    }

    public String getNameID() {
        return nameID;
    }

    @Override
	public String toString() {
		String msj = "Nombre = " + this.nameID + "\n" +
                     "Tipo = " + this.typeString + "\n" + 
					 "Puntaje otorgado al ganar = " + this.winPoints + "\n" +
                     "Puntaje restado al perder = " + this.lostPoints + "\n" +
					 "Coordenadas = X:" + this.XPosition + ", Y:" + this.YPosition + "\n";
		return msj;
	}

    public EnemyType getType() {
        return type;
    }

    public double getWinPoints() {
        return winPoints;
    }
}
