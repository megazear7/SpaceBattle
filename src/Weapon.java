import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class Weapon {

	private int damage;
	private String type;
	private String name;
	
    public Weapon(int damage, String type, String name) {
    	this.damage = damage;
    	this.type = type;
    	this.name = name;
    }

    public int damage(){
    	return this.damage;
    }
    public void damage(int damage){
    	this.damage = damage;
    }
    public void addDamage(int damage){
    	this.damage = this.damage + damage;
    }
    public String type(){
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
    	Weapon test = new Weapon(5, "none", "test");
    }

}
