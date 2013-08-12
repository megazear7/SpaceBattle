package gameEngine;

public class Engine {

	private int posX;
	private int posY;
	private int power; 
	private int facing;
	
	public Engine(int posX, int posY, int power, int facing){
		this.posX = posX;
		this.posY = posY;
		this.power = power;
		this.facing = facing;
	}

	public int posX() {
		return posX;
	}

	public void posX(int posX) {
		this.posX = posX;
	}

	public void addPosX(int posX) {
		this.posX += posX;
	}
	public int posY() {
		return posY;
	}

	public void posY(int posY) {
		this.posY = posY;
	}

	public void addPosY(int posY) {
		this.posY += posY;
	}
	public int power() {
		return power;
	}

	public void power(int power) {
		this.power = power;
	}

	public void addPower(int power) {
		this.power += power;
	}
	public int facing() {
		return facing;
	}

	public void facing(int facing) {
		this.facing = facing;
	}
	
	public void addFacing(int facing) {
		this.facing += facing;
	}
}
