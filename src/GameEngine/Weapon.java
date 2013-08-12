package gameEngine;

public final class Weapon {

	private int damage;
	private int typeNum;
	private String type;
	private String name;
	private int range;
	private int facing;
	
    public Weapon(int damage, String type, String name, int range, int facing) {
    	this.damage = damage;
    	this.type = type;
    	this.name = name;
    	this.range = range;
    	this.facing = facing;
    	
    	if (type.equals("physical")){
    		this.typeNum = 0;
    	}else if (type.equals("phase")){
    		this.typeNum = 1;
    	}else if (type.equals("laser")){
    		this.typeNum = 2;
    	}else if (type.equals("plasma")){
    		this.typeNum = 3;
    	}else{
    		this.typeNum = -1;
    	}
    	
    }

    public int typeNum(){
    	return this.typeNum;
    }
    public int facing(){
    	return this.facing;
    }
    public void facing(int facing){
    	this.facing = facing;
    }
    public void addFacing(int facing){
    	this.facing = this.facing + facing;
    }    public int damage(){
    	return this.damage;
    }
    public void damage(int damage){
    	this.damage = damage;
    }
    public void addDamage(int damage){
    	this.damage = this.damage + damage;
    }
    public int range(){
    	return this.range;
    }
    public void range(int range){
    	this.range = range;
    }
    public void addRange(int range){
    	this.range = this.range + range;
    }    public String type(){
    	return this.type;
    }
    public void type(String type){
    	this.type = type;
    }
    public String name(){
    	return this.name;
    }
    public void name(String name){
    	this.name = name;
    }
    
    public static void main(String[] args) {
    }

}
