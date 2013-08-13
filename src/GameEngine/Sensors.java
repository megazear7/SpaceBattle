package gameEngine;

import java.util.List;
import util.Utils;

public final class Sensors {

    /**
     * This function, given a action, essentially redirect to the correct action function in this class
     * @param action
     * @param origin
     * @return
     */
    public static EnviroEffect action(BattleController battleField, Command command, Ship origin){
    	EnviroEffect result = new EnviroEffect();
    	
    	if(command.action().equals("check")){
    		result = check(result, origin, command.argument());
    	} else if(command.action().equals("target")){
    		result = target(result, origin, command.argument(), battleField);
    	} else if(command.action().equals("location")){
  	   		// should not be used in real game used for testing
    		result = location(result, origin, battleField);
    	} else if(command.action().equals("scan")){
    		result = scan(result, origin, command.argument(), battleField);
    	} else {
    		origin.input().sendMessage("Your action that was sent to the sensory array tower room was not recognized");
    	}
    	return result;
    }
    
    private static EnviroEffect location(EnviroEffect result, Ship ship, BattleController battleField){
    	//ship.input().sendMessage(("The " + ship.shipName() + " location info is:\nposX: " + ship.posX() + "\nposY: " + ship.posY() + "\nfacing: " + ship.facing() + "\n"));

    	// not meant to be used for the actual game
    	return result;
    }
    
    
    private static EnviroEffect scan(EnviroEffect result, Ship ship, String argument, BattleController battleField){
    	
    	if(argument.contains("front")){
    		List<Ship> ships = Utils.removeNotInArc(ship, ship.facing(), battleField.otherShips(ship));
    		int size = ships.size();
   			ship.input().sendMessage("In your front arc: ");
    		for(int i = 0; i < size; i++){
    			int distance = Utils.findDistance(ship, ships.get(i));
    			ship.input().sendMessage("The " + ships.get(i).shipName() + " is " + distance + " parsecc's away");
    		}
    	} else if (argument.contains("left")){
     		List<Ship> ships = Utils.removeNotInArc(ship, ship.leftFace(), battleField.otherShips(ship));
    		int size = ships.size();
   			ship.input().sendMessage("In your left arc: ");
    		for(int i = 0; i < size; i++){
    			int distance = Utils.findDistance(ship, ships.get(i));
    			ship.input().sendMessage("The " + ships.get(i).shipName() + " is " + distance + " parsecc's away");
    		}   		
    	} else if (argument.contains("right")){
    		List<Ship> ships = Utils.removeNotInArc(ship, ship.rightFace(), battleField.otherShips(ship));
    		int size = ships.size();
   			ship.input().sendMessage("In your right arc: ");
    		for(int i = 0; i < size; i++){
    			int distance = Utils.findDistance(ship, ships.get(i));
    			ship.input().sendMessage("The " + ships.get(i).shipName() + " is " + distance + " parsecc's away");
    		}
    	} else if (argument.contains("rear")){
    		List<Ship> ships = Utils.removeNotInArc(ship, ship.rearFace(), battleField.otherShips(ship));
    		int size = ships.size();
   			ship.input().sendMessage("In your rear arc: ");
    		for(int i = 0; i < size; i++){
    			int distance = Utils.findDistance(ship, ships.get(i));
    			ship.input().sendMessage("The " + ships.get(i).shipName() + " is " + distance + " parsecc's away");
    		}
    	} else if (argument.contains("nearest-ship")){
    		Ship target = Utils.findNearest(ship, battleField.otherShips(ship));
    		int distance = Utils.findDistance(ship, target);
    		String face = Utils.whichFace(ship, target);
   			ship.input().sendMessage("The closest ship is the " + target.shipName() + " and it is " + distance + " parsecc's away on our " + face);
    	} else if (argument.contains("target")){
    		Ship target = Utils.findNearest(ship, battleField.otherShips(ship));
    		int distance = Utils.findDistance(ship, target);
    		String face = Utils.whichFace(ship, target);
   			ship.input().sendMessage("Our target is the " + target.shipName() + " and it is " + distance + " parsecc's away on our " + face);
    	}
    	return result;
    }
    
    private static EnviroEffect target(EnviroEffect result, Ship ship, String argument, BattleController battleField){
    	int weapon = 0;
    	int length = ship.weapons().size();
    	for (int i = 0; i < length; i++){
    		if(argument.contains(ship.weapons().get(i).name())){
    			weapon = i;
    		}
    	}	
    	
    	int distance = 0;
    	int message = 1;
    	String face = "";
    	if(argument.contains("front")){
    		Ship newTarget = Utils.keepBestTarget(ship, ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);
    		distance = Utils.findDistance(ship, newTarget);
    		face = Utils.whichFace(ship, newTarget);    	} else if(argument.contains("left")){
     		Ship newTarget = Utils.keepBestTarget(ship, ship.leftFace(), ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);   		
    		distance = Utils.findDistance(ship, newTarget);
    		face = Utils.whichFace(ship, newTarget);    	}else if(argument.contains("right")){
     		Ship newTarget = Utils.keepBestTarget(ship, ship.rightFace(), ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);   		
    		distance = Utils.findDistance(ship, newTarget);
    		face = Utils.whichFace(ship, newTarget);
    	} else if(argument.contains("rear")){
     		Ship newTarget = Utils.keepBestTarget(ship, ship.rearFace(), ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);   		
    		distance = Utils.findDistance(ship, newTarget);
    		face = Utils.whichFace(ship, newTarget);     	} else if (argument.contains("nearest-ship")){
    		Ship newTarget = Utils.findNearest(ship, battleField.otherShips(ship));
    		ship.target(newTarget);    		distance = Utils.findDistance(ship, newTarget);
    		face = Utils.whichFace(ship, newTarget);    	} else {
    		ship.input().sendMessage("that command was mis understood");
    		message = 0;
    	}

    	if(message == 1){
    		ship.input().sendMessage("Our new target is the " + ship.target().shipName() + ", it is " + distance + " parsecc's away on our " + face );
    	}

    	return result;
    }
    
    private static EnviroEffect check(EnviroEffect result, Ship ship, String argument){
    	boolean checkAll = false;
    	boolean commandFound = false;
    	if (argument.contains("all")){
    		checkAll = true;
    	}
    	
    	if(argument.contains("power") || checkAll){
    		ship.input().sendMessage("Power Stats:");
    		ship.input().sendMessage("Our Power is at " + ship.power());
    		ship.input().sendMessage("Our Engine Power is at " + ship.enginePower());
    		ship.input().sendMessage("Our Weapon Power is at " + ship.weaponPower());
    		ship.input().sendMessage("Our Shield Power is at " + ship.shieldPower());
    		ship.input().sendMessage("Our un-stabilness is " + ship.instability());
    		ship.input().sendMessage("We have " + ship.health() + " health left");
    		commandFound = true;
    	}
    	if(argument.contains("shields") || checkAll){
    		ship.input().sendMessage("Shield Stats:");
    		ship.input().sendMessage("Our shield power is at " + ship.shieldPower());
    		ship.input().sendMessage("Our front shields are at " + ship.frontShield());
    		ship.input().sendMessage("Our left shields are at " + ship.leftShield());
    		ship.input().sendMessage("Our right shields are at " + ship.rightShield());
    		ship.input().sendMessage("Our rear shields are at " + ship.rearShield());
    		commandFound = true;
    	}
     	if(argument.contains("weapons") || checkAll){
    		ship.input().sendMessage("Weapon Stats:");
     		int size = ship.weapons().size();
     		ship.input().sendMessage("Our weapon power is at " + ship.weaponPower());
     		for (int i = 0; i < size; i++){
     			ship.input().sendMessage("Your " + ship.weapons().get(i).name() + 
     					"'s have damage: " + ship.weapons().get(i).damage() + 
     					", have a range of " + ship.weapons().get(i).range() + 
     					", are pointing in a position of " + ship.weapons().get(i).facing() + 
     					" and are " + ship.weapons().get(i).type() + " weapons");
     		}
    		commandFound = true;
    	}   	
    	if(argument.contains("engines") || checkAll){
    		ship.input().sendMessage("Engine Stats:");
    		ship.input().sendMessage("Our engines are at " + ship.enginePower());
    		commandFound = true;
    	}
    	
    	if(!commandFound){
    		ship.input().sendMessage("what systems do you want to check? '" + argument + "' wasn't recognized");
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
    }

}
