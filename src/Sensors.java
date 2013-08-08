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
    		result = target(result, origin, command.argument());
    	}  	
    	return result;
    }
    
    private static EnviroEffect target(EnviroEffect result, Ship ship, String argument){
    	
    	if(argument.contains("front")){
    		
    	}
     	if(argument.contains("left")){
    		
    	}   	
    	if(argument.contains("right")){

    	}	
     	if(argument.contains("right")){

     	}	
    	return result;
    }
    
    private static EnviroEffect check(EnviroEffect result, Ship ship, String argument){
    	
    	if(argument.contains("power")){
    		ship.input().sendMessage("Your Power is at " + ship.power());
    	}
    	if(argument.contains("shields")){
    		ship.input().sendMessage("Your front shields are at " + ship.frontShield());
    		ship.input().sendMessage("Your other shields are at " + ship.otherShield());
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
