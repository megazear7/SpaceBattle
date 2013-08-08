import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class Engines {

    /**
     * This function, given a action, essentially redirect to the correct action function in this class
     * @param action
     * @param origin
     * @return
     */
    public static EnviroEffect action(BattleController battleField, Command command, Ship origin){
    	EnviroEffect result = new EnviroEffect();
    	
    	if(command.action().equals("engage")){
    		result = engage(result, origin, command.argument());
    	}
     	if(command.action().equals("selfdestruct")){
    		result = destruct(result, origin, command.argument());
    	}   	
    	return result;
    }
    
    private static EnviroEffect destruct(EnviroEffect result, Ship ship, String argument){
    	ship.isDestroyed(true);
    	return result;
    }
    
    private static EnviroEffect engage(EnviroEffect result, Ship ship, String argument){
    	int moveForward = 0;
    	int moveSide = 0;
    	
    	if (argument.contains("thrusters")){
    		moveForward = ship.enginePower();
    	}
     	if (argument.contains("sidekicks") && argument.contains("left")){
    		moveForward = ship.enginePower() / 2;
    		moveSide = ship.enginePower() / 2;
    	}   	
     	if (argument.contains("sidekicks") && argument.contains("right")){
    		moveForward = ship.enginePower() / 2;
    		moveSide = ship.enginePower() / 2;
    	}
    	if (argument.contains("halters")){
    		moveForward = (ship.enginePower() / 2) * -1;
    	}
    	
    	int newX = ship.posX() + moveSide;
    	int newY = ship.posY() + moveForward;
    	
    	return result;
    }

    public static void main(String[] args) {
    }

}
