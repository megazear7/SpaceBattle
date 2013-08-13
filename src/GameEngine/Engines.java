package gameEngine;

import util.Utils;

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
    	if(command.action().equals("boost")){
    		result = boost(result, origin, command.argument());
    	}     	if(command.action().equals("self-destruct")){
    		result = destruct(result, origin, command.argument());
    	}      	if(command.action().equals("stabalize")){
    		result = stabalize(result, origin);
    	}  	
    	return result;
    }
    
    private static EnviroEffect boost(EnviroEffect result, Ship ship, String argument){
    	boolean left = false;
    	int frontToRemove = 0;
    	boolean validParam = false;
    	if (argument.contains("left")){
    		left = true;
    		frontToRemove = 4;
    		validParam = true;
    	} if (argument.contains("right")){
    		left = false;
    		frontToRemove = 5;
    		validParam = true;
    	}
    	if (validParam) { 
    		String removeFront = argument.substring(frontToRemove);
    		int dash = removeFront.indexOf("-");
    		removeFront = removeFront.substring(0, dash);
    		int number = Integer.parseInt(removeFront);
    		if (argument.contains("Deg")){
    		
    		} else if (argument.contains("%")){
    		
    		}else{
    			if(left){
    				ship.addFacing(number * -1);
    			}else{
    				ship.addFacing(number);
    			}
    		}
    	}
    	return result;
    }
    
    private static EnviroEffect destruct(EnviroEffect result, Ship ship, String argument){
    	ship.isDestroyed(true);
    	return result;
    }
     
    private static EnviroEffect stabalize(EnviroEffect result, Ship ship){
    	ship.instability(0);
    	return result;
    }

    private static EnviroEffect engage(EnviroEffect result, Ship ship, String argument){
    	int moveForward = 0;
    	int moveSide = 0;
    	double throttle = 1;
    	
    	if (argument.contains("half-power")){
    		throttle = .5;
    	} else if (argument.contains("third-power")){
    		throttle = .33;
    	} else if (argument.contains("quarter-power")){
    		throttle = .25;
    	}

    	
    	if (argument.contains("thrusters")){
    		moveForward = (int) ((ship.enginePower()) * throttle);
    	}
     	if (argument.contains("sidekicks") && argument.contains("left")){
    		moveForward = (int) ((ship.enginePower() / 2) * throttle);
    		moveSide = (int) ((ship.enginePower() / 2) * throttle);
    	}   	
     	if (argument.contains("sidekicks") && argument.contains("right")){
    		moveForward = (int) ((ship.enginePower() / 2) * throttle);
    		moveSide = (int) ((ship.enginePower() / 2) * throttle);
    	}
    	if (argument.contains("halters")){
    		moveForward = (int) (((ship.enginePower() / 2) * -1) * throttle);
    	}
    	
    	//int[] coord = Utils.giveMovement(moveForward, moveSide, ship.facing());
    	int[] coord = Utils.giveMovement(moveSide, moveForward, ship.facing());
    	
    	ship.addPosX(coord[0]);
    	ship.addPosY(coord[1]);
    	
    	
    	return result;
    }

    public static void main(String[] args) {
    }

}
