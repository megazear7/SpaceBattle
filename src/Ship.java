import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import java.util.ArrayList;
import java.util.List;

public final class Ship {

	private Ship target;
	private BattleController battleController;
	private int health;
	private int shields;
	private int weaponDamage;
	private List<Weapon> weapons;
	private int enginePower;
	private int shieldPower;
	private int frontShield;
	private int otherShield;
	private int power;
	private int posX; // This is always relative to the BattleControllers originX
	private int posY; // This is always relative to the BattleControllers originY
	private int facing; // this is 1-12 (like a clock)
	private Input input;
	private  boolean isDestroyed;
	private String shipName;
	
    public Ship(BattleController battleController, int health, int shields, int weaponDamage, int enginePower, int shieldPower, 
    		int frontShield, int otherShield, int power, int posY, int posX, int facing, Input input, String name, List<Weapon> weapons) {
    	this.battleController = battleController;
    	this.health = health;
    	this.shields = shields;
    	this.weaponDamage = weaponDamage;
    	this.enginePower = enginePower;
    	this.shieldPower = shieldPower;
    	this.frontShield = frontShield;
    	this.otherShield = otherShield;
    	this.power = power;
    	this.posX = posX;
    	this.posY = posY;
    	this.facing = facing; // 1 - 16 (like an expanded clock)
    	this.input = input;
    	this.shipName = name;
    	this.weapons = weapons;
    }
    public Ship(){
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
    public boolean isDestroyed(){
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
    public int otherShield(){
    	return this.otherShield;
    }
    public void otherShield(int shieldVal){
    	this.otherShield = shieldVal;
    }
    public void addOtherShield(int shieldVal){
    	this.otherShield = this.otherShield + shieldVal;
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
    public int shields(){
    	return this.shields;
    } 
    public int weaponDamage(){
    	return this.weaponDamage;
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
    public void shields(int shields){
    	this.shields = shields;
    } 
    public void weaponDamage(int damage){
    	this.weaponDamage = damage;
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
    public void addShields(int shields){
    	this.shields = this.shields + shields;
    } 
    public void addWeaponDamage(int damage){
    	this.weaponDamage = this.weaponDamage + damage;
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
    
    public static void main(String[] args) {
    	Weapon test = new Weapon(4, "none", "test");

    }

}
