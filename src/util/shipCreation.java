package util;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

import gameEngine.BattleController;
import gameEngine.Ship;
import gameEngine.Weapon;

public class shipCreation {
	
	private shipCreation(){
	}	
	
	private static List<Weapon> retrieveShipWeapons(String shipName){
		// create input stream from a file
    	SimpleReader in = new SimpleReader1L("lib/weapons.txt");
    	
    	// create a String out of the file, reading in each line until end of stream is hit
    	String weaponsString = "";
    	while(!in.atEOS()){
    		weaponsString = weaponsString + in.nextLine() + "\n";
		
    	}
    	
    	// make a json object out of the string using JSONValue.parse
    	JSONObject fileJSON = (JSONObject)JSONValue.parse(weaponsString);
	
    	// make a empty json object
    	JSONArray weaponsJSON = new JSONArray();
    	
    	// check to make sure the object contains the key your looking for
    	if (fileJSON.containsKey("enterprise")){
    		// make a plain object using the entire json object's get method
    		weaponsJSON = (JSONArray) fileJSON.get("enterprise");
    	}
    	
    	
   		List<Weapon> weapons = new ArrayList<Weapon>();
    	int length = weaponsJSON.size();
    	for(int i = 0; i < length; i++){
    		JSONObject weaponJSON = (JSONObject) weaponsJSON.get(i);
    		Weapon weapon = new Weapon(
    					Integer.parseInt((String) weaponJSON.get("damage")),	// damage
    					(String) weaponJSON.get("type"),						// type
    					(String) weaponJSON.get("name"),						// name
    					Integer.parseInt((String) weaponJSON.get("range")),	// range
    					Integer.parseInt((String) weaponJSON.get("facing"))	// facing
    				);
    		weapons.add(weapon);
    	}
    	
    	
		return weapons;
	}
	
	public static Ship createShip(String shipName, BattleController controller, Input input, int posX, int posY, int facing){
		// create input stream from a file
    	SimpleReader in = new SimpleReader1L("lib/ships.txt");
    	
    	List<Weapon> weapons = retrieveShipWeapons(shipName);
    	
    	// create a String out of the file, reading in each line until end of stream is hit
    	String ships = "";
    	while(!in.atEOS()){
    		ships = ships + in.nextLine() + "\n";
		
    	}
    	
    	// make a json object out of the string using JSONValue.parse
    	JSONObject fileJSON = (JSONObject)JSONValue.parse(ships);
	
    	// make a empty json object
    	JSONObject shipJSON = new JSONObject();
    	
    	// check to make sure the object contains the key your looking for
    	if (fileJSON.containsKey(shipName)){
    		// make a plain object using the entire json object's get method
    		Object shipPlain = fileJSON.get(shipName);
    		// cast the plain object to a JSON object
    		shipJSON = (JSONObject) shipPlain;
    	}
    	
    	// now you have a ship represented by a json object that was retrieved from a file that is a list of ships
		
		// make a ship out of its data
		Ship ship = new Ship(
    			controller,													// BattleController
    			Integer.parseInt((String) shipJSON.get("health")),			// Health
    			Integer.parseInt((String) shipJSON.get("weaponPower")),		// weaponPower
    			Integer.parseInt((String) shipJSON.get("enginePower")),		// enginePower
    			Integer.parseInt((String) shipJSON.get("shieldPower")),		// shieldPower
    			Integer.parseInt((String) shipJSON.get("frontShield")),		// frontShield
    			Integer.parseInt((String) shipJSON.get("leftShield")),		// leftShield
    			Integer.parseInt((String) shipJSON.get("rightShield")),		// rightShield
    			Integer.parseInt((String) shipJSON.get("rearShield")),		// rearShield
    			posX,														// posX
    			posY,														// posY
    			facing,														// facing
    			input,														// input
    			(String) shipJSON.get("shipName"),							// name
    			weapons														// list of weapons
    	);
		
		// "add the ship to the weapons"
		int size = ship.weapons().size();
		for (int i = 0; i < size; i++){
			ship.weapons().get(i).addShip(ship);
		}
		// return the ship
		return ship;
	}
	
	public static void main(String[] args) {
		createShip("enterprise", null, null, 5, 5, 5);
		System.out.print("");
    }

}
