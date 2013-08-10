import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

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
    	}
     	if(command.action().equals("target")){
    		result = target(result, origin, command.argument(), battleField);
    	}  	   	if(command.action().equals("location")){
  	   		// should not be used in real game used for testing
    		result = location(result, origin, battleField);
    	}
    	
    	if(command.action().equals("detect")){
    		result = detect(result, origin, command.argument(), battleField);
    	}
    	return result;
    }
    
    private static EnviroEffect location(EnviroEffect result, Ship ship, BattleController battleField){
    	ship.input().sendMessage(("The " + ship.shipName() + " location info is:\nposX: " + ship.posX() + "\nposY: " + ship.posY() + "\nfacing: " + ship.facing()));

    	// not meant to be used for the actual game
    	return result;
    }
    
    
    private static EnviroEffect detect(EnviroEffect result, Ship ship, String argument, BattleController battleField){
    	
    	if(argument.contains("forward")){
    		
    	} else if (argument.contains("left")){
    		
    	} else if (argument.contains("right")){
    		
    	} else if (argument.contains("rear")){
    		
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
    	
    	if(argument.contains("front")){
    		Ship newTarget = Utils.keepBestTarget(ship, ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);
    	}
     	if(argument.contains("left")){
     		Ship newTarget = Utils.keepBestTarget(ship, ship.leftFace(), ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);   		
    	}   	
    	if(argument.contains("right")){
     		Ship newTarget = Utils.keepBestTarget(ship, ship.rightFace(), ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);   		
    	}	
     	if(argument.contains("back")){
     		Ship newTarget = Utils.keepBestTarget(ship, ship.rearFace(), ship.weapons().get(weapon).range(), battleField.ships());
    		ship.target(newTarget);   		
     	}	

    	return result;
    }
    
    private static EnviroEffect check(EnviroEffect result, Ship ship, String argument){
    	
    	if(argument.contains("power")){
    		ship.input().sendMessage("Your Power is at " + ship.power());
    	}
    	if(argument.contains("shields")){
    		ship.input().sendMessage("Your front shields are at " + ship.frontShield());
    		ship.input().sendMessage("Your left shields are at " + ship.leftShield());
    		ship.input().sendMessage("Your right shields are at " + ship.rightShield());
    		ship.input().sendMessage("Your rear shields are at " + ship.rearShield());
    	}
     	if(argument.contains("weapons")){
     		int size = ship.weapons().size();
     		for (int i = 0; i < size; i++){
     			ship.input().sendMessage("Your " + ship.weapons().get(i).name() + 
     					"'s have damage: " + ship.weapons().get(i).damage() + 
     					" and are of damage type " + ship.weapons().get(i).type());
     		}
    	}   	
    	if(argument.contains("engines")){
    		ship.input().sendMessage("Your engines are at " + ship.enginePower());
    	}
    	return result;
    }

    public static void main(String[] args) {
    }

}
