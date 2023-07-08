package Objects;

public class Bullet {
	private double posX;	
	private double posY;
	private double vDirX;
	private double vDirY;
	private double speed;  
	
	public Bullet(double posX, double posY, double speed) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void move(double enemyPosX, double enemyPosY) {
		posX = speed * calcDirecX(enemyPosX, enemyPosY);
		posY = speed * calcDirY(enemyPosY, enemyPosX);
	}
	
	private double calcDirecX(double enemyPosX, double enemyPosY) {
		return (enemyPosX - posX)/Math.sqrt(Math.pow(enemyPosY - posY, 2) + Math.pow(enemyPosX-posX, 2)) ;
		
	}
	private double calcDirY(double enemyPosY, double enemyPosX) {
		return (enemyPosY - posY)/Math.sqrt(Math.pow(enemyPosY - posY, 2) + Math.pow(enemyPosX-posX, 2)) ;
	}

	
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public double getvDirX() {
		return vDirX;
	}

	public double getvDirY() {
		return vDirY;
	}

	public double getSpeed() {
		return speed;
	}
	
	

}
