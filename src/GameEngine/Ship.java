package gameEngine;
import java.util.List;

import util.Input;

public final class Ship {

	private Ship target;
	private BattleController battleController;
	private int health;
	private int weaponPower;
	private List<Weapon> weapons;
	private int shieldPower;
	private int power;
	private Input input;
	private  boolean isDestroyed;
	private String shipName;
	private boolean realShip;
	private int instability;
	private Engine engine;
	private Shield shield;
	
    public Ship(BattleController battleController, int health, int weaponPower, int enginePower, int shieldPower, 
    		int frontShield, int leftShield, int rightShield, int rearShield, int posX, int posY, int facing, Input input, String name, List<Weapon> weapons) {
    	this.battleController(battleController);
    	this.health = health;
    	this.power = 1;
    	this.weaponPower = weaponPower;
    	this.input = input;
    	this.shipName = name;
    	this.weapons = weapons;
    	this.realShip = true;
    	this.instability = 0;    	this.shield(new Shield(shieldPower, frontShield, leftShield, rightShield, rearShield));
    	this.engine(new Engine(enginePower, posX, posY, facing));
    }

    public Ship(){
    	this.realShip = false;
    }   

    public int shieldPower(){
    	return this.shieldPower;
    }
    public void shieldPower(int power){
    	this.shieldPower = power;
    }
    public void addShieldPower(int power){
    	this.shieldPower = this.shieldPower + power;
    }   
    
    public int instability(){
    	return this.instability;
    }
    public void instability(int a){
    	this.instability = a;
    }
    public void addInstability(int a){
    	this.instability = this.instability + a;
    }     
    public List<Weapon> weapons(){
    	return this.weapons;
    }
    public void addWeapon(Weapon weapon){
    	this.weapons.add(weapon);
    }
    public void removeWeapon(String weapon){
    	int size = this.weapons.size();
    	for(int i = 0; i < size; i++){
    		if(this.weapons.get(i).name().equals(weapon)){
    			this.weapons.remove(i);
    		}
    	}
    }    
    public boolean realShip(){
    	return this.realShip;
    }
    public String shipName(){
    	return this.shipName;
    }
    public void shipName(String name){
    	this.shipName = name;
    }   
    public int facing(){
    	return this.engine().facing();
    }
    public void facing(int facing){
    	this.engine().facing(facing);
    }
    public void addFacing(int facing){
    	this.engine().addFacing(facing);
    }     
    public int leftFace(){
    	int left = this.engine().facing() - 4;
    	if (left < 1){
    		left += 16;
    	}
    	return left;
    }
    public int rightFace(){
    	int right = this.engine().facing() + 4;
    	if (right > 16){
    		right -= 16;
    	}
    	return right;
    }    public int rearFace(){
    	int rear = this.engine().facing() - 8;
    	if (rear < 1){
    		rear += 16;
    	}
    	return rear;
    }    public boolean isDestroyed(){
    	if(this.health() < 1){
    		this.isDestroyed = true;
    	}
    	return this.isDestroyed;
    }
    public void isDestroyed(boolean destroy){
    	this.isDestroyed = destroy;
    }  
    public Ship target(){
    	return this.target;
    }
    public void target(Ship ship){
    	this.target = ship;
    }
    public Input input(){
    	return this.input;
    }
    public void input(Input input){
    	this.input = input;
    }
    public int leftShield(){
    	return this.shield().left();
    }
    public void leftShield(int shieldVal){
    	this.shield().left(shieldVal);
    }
    public void addLeftShield(int shieldVal){
    	this.shield().addLeft(shieldVal);
    }   
    public int rightShield(){
    	return this.shield().right();
    }
    public void rightShield(int shieldVal){
    	this.shield().right(shieldVal);
    }
    public void addRightShield(int shieldVal){
    	this.shield().addRight(shieldVal);
    }   
    public int rearShield(){
    	return this.shield().rear();
    }
    public void rearShield(int shieldVal){
    	this.shield().rear(shieldVal);
    }
    public void addRearShield(int shieldVal){
    	this.shield().addRear(shieldVal);
    }   
    public int frontShield(){
    	return this.shield().front();
    }
    public void frontShield(int shieldVal){
    	this.shield().front(shieldVal);
    }
    public void addFrontShield(int shieldVal){
    	this.shield().addFront(shieldVal);
    }  
    public int health(){
    	return this.health;
    }
    public int weaponPower(){
    	return this.weaponPower;
    } 
    public int enginePower(){
    	return this.engine().power();
    } 
    public int power(){
    	return this.power;
    }
    public int posX(){
    	return this.engine().posX();
    }     public int posY(){
    	return this.engine().posY();
    }     public void health(int health){
    	this.health = health;
    }
    public void weaponPower(int power){
    	this.weaponPower = power;
    } 
    public void enginePower(int power){
    	this.engine().power(power);
    } 
    public void power(int power){
    	this.power = power;
    } 
    public void posX(int newX){
    	this.engine().posX(newX);
    }
    public void posY(int newY){
    	this.engine().posY(newY);
    }
    public void addHealth(int health){
    	this.health = this.health + health;
    }
    public void addWeaponPower(int power){
    	this.weaponPower = this.weaponPower + power;
    } 
    public void addEnginePower(int power){
    	this.engine().addPower(power);
    } 
    public void addPower(int power){
    	this.power = this.power + power;
    } 
    public void addPosX(int newX){
    	this.engine().addPosX(newX);
    }
    public void addPosY(int newY){
    	this.engine().addPosY(newY);
    }
    public Weapon weapon(String name){
    	int length = this.weapons().size();
    	Weapon weapon = null;
    	for(int i = 0; i < length; i++){
    		if (this.weapons().get(i).name().equals(name)){
    			weapon = this.weapons().get(i);
    		}
    	}
    	return weapon;
    }
    
    
    public static void main(String[] args) {
    }

	public BattleController battleController() {
		return battleController;
	}

	public void battleController(BattleController battleController) {
		this.battleController = battleController;
	}

	public Engine engine() {
		return engine;
	}

	public void engine(Engine engine) {
		this.engine = engine;
	}

	public Shield shield() {
		return shield;
	}

	public void shield(Shield shield) {
		this.shield = shield;
	}

}
