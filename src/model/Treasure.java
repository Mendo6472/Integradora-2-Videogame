package model;
import java.util.Random;

public class Treasure {

	private int VERTICAL_RESOLUTION;
    private int HORIZONTAL_RESOLUTION;
	private String name;
	private String imageURL;
	private double scoreGranted;
	private double xPosition;
	private double yPosition;
	private Random random;

	/**
	 * @param VERTICAL_RESOLUTION
	 * @param HORIZONTAL_RESOLUTION
	 * @param name
	 * @param imageURL
	 * @param scoreGranted
	 */
	public Treasure(int VERTICAL_RESOLUTION, int HORIZONTAL_RESOLUTION, String name, String imageURL, double scoreGranted) {
		this.random = new Random();
		this.VERTICAL_RESOLUTION = VERTICAL_RESOLUTION;
		this.HORIZONTAL_RESOLUTION = HORIZONTAL_RESOLUTION;
		this.name = name;
		this.imageURL = imageURL;
		this.scoreGranted = scoreGranted;
		this.xPosition = random.nextInt(this.HORIZONTAL_RESOLUTION);
		this.yPosition = random.nextInt(this.VERTICAL_RESOLUTION);
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

	public String getImageURL() {
		return this.imageURL;
	}

	/**
	 * 
	 * @param imageURL
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public double getScoreGranted() {
		return this.scoreGranted;
	}

	/**
	 * 
	 * @param scoreGranted
	 */
	public void setScoreGranted(double scoreGranted) {
		this.scoreGranted = scoreGranted;
	}

	public double getXPosition() {
		return this.xPosition;
	}

	/**
	 * 
	 * @param xPosition
	 */
	public void setXPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getYPosition() {
		return this.yPosition;
	}

	/**
	 * 
	 * @param yPosition
	 */
	public void setYPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	@Override
	public String toString() {
		String msj = "Nombre = " + this.name + "\n" +
					 "URL de imagen = " + this.imageURL + "\n" +
					 "Puntaje otorgado = " + this.scoreGranted + "\n" +
					 "Coordenadas = X:" + this.xPosition + ", Y:" + this.yPosition + "\n";
		return msj;
	}

}