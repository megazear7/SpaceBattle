package gameEngine;
import java.util.List;

import util.Input;

public final class Ship {

	private Ship target;
	private BattleController battleController;
	private int health;
	private int weaponPower;
	private List<Weapon> weapons;
	private int enginePower;
	private int shieldPower;
	private int frontShield;
	private int rightShield;
	private int leftShield;
	private int rearShield;
	private int power;
	private int posX; // This is always relative to the BattleControllers originX
	private int posY; // This is always relative to the BattleControllers originY
	private int facing; // this is 1-12 (like a clock)
	private Input input;
	private  boolean isDestroyed;
	private String shipName;
	private boolean realShip;
	private int instability;
	
    public Ship(BattleController battleController, int health, int weaponPower, int enginePower, int shieldPower, 
    		int frontShield, int leftShield, int rightShield, int rearShield, int posY, int posX, int facing, Input input, String name, List<Weapon> weapons) {
    	this.battleController(battleController);
    	this.health = health;
    	this.shieldPower = shieldPower;
    	this.weaponPower = weaponPower;
    	this.enginePower = enginePower;
    	this.shieldPower = shieldPower;
    	this.frontShield = frontShield;
    	this.leftShield = leftShield;
    	this.rightShield = rightShield;
    	this.rearShield = rearShield;
    	this.power = 1;
    	this.posX = posX;
    	this.posY = posY;
    	this.facing = facing; // 1 - 16 (like an expanded clock)
    	this.input = input;
    	this.shipName = name;
    	this.weapons = weapons;
    	this.realShip = true;
    	this.instability = 0;
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
    	return this.facing;
    }
    public void facing(int facing){
    	this.facing = power;
    }
    public void addfacing(int facing){
    	this.facing = this.facing + facing;
    }     
    public int leftFace(){
    	int left = this.facing() - 4;
    	if (left < 1){
    		left += 16;
    	}
    	return left;
    }
    public int rightFace(){
    	int right = this.facing() + 4;
    	if (right > 16){
    		right -= 16;
    	}
    	return right;
    }    public int rearFace(){
    	int rear = this.facing() - 8;
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
    	return this.leftShield;
    }
    public void leftShield(int shieldVal){
    	this.leftShield = shieldVal;
    }
    public void addLeftShield(int shieldVal){
    	this.leftShield = this.leftShield + shieldVal;
    }   
    public int rightShield(){
    	return this.rightShield;
    }
    public void rightShield(int shieldVal){
    	this.rightShield = shieldVal;
    }
    public void addRightShield(int shieldVal){
    	this.rightShield = this.rightShield + shieldVal;
    }   
    public int rearShield(){
    	return this.rearShield;
    }
    public void rearShield(int shieldVal){
    	this.rearShield = shieldVal;
    }
    public void addRearShield(int shieldVal){
    	this.rearShield = this.rearShield + shieldVal;
    }   
    public int frontShield(){
    	return this.frontShield;
    }
    public void frontShield(int shieldVal){
    	this.frontShield = shieldVal;
    }
    public void addFrontShield(int shieldVal){
    	this.frontShield = this.frontShield + shieldVal;
    }  
    public int health(){
    	return this.health;
    }
    public int weaponPower(){
    	return this.weaponPower;
    } 
    public int enginePower(){
    	return this.enginePower;
    } 
    public int power(){
    	return this.power;
    }
    public int posX(){
    	return this.posX;
    }     public int posY(){
    	return this.posY;
    }     public void health(int health){
    	this.health = health;
    }
    public void weaponPower(int power){
    	this.weaponPower = power;
    } 
    public void enginePower(int power){
    	this.enginePower = power;
    } 
    public void power(int power){
    	this.power = power;
    } 
    public void posX(int newX){
    	this.posX = newX;
    }
    public void posY(int newY){
    	this.posY = newY;
    }
    public void addHealth(int health){
    	this.health = this.health + health;
    }
    public void addWeaponPower(int power){
    	this.weaponPower = this.weaponPower + power;
    } 
    public void addEnginePower(int power){
    	this.enginePower = this.enginePower + power;
    } 
    public void addPower(int power){
    	this.power = this.power + power;
    } 
    public void addPosX(int newX){
    	this.posX = this.posX + newX;
    }
    public void addPosY(int newY){
    	this.posY = this.posY + newY;
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

}
