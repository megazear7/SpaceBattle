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
    	} else if(command.action().equals("boost")){
    		result = boost(result, origin, command.argument());
    	} else if(command.action().equals("self-destruct")){
    		result = destruct(result, origin, command.argument());
    	} else if(command.action().equals("stabalize")){
    		result = stabalize(result, origin);
    	} else if(command.action().equals("divert-power")){
    		result = divertPower(result, origin, command.argument());
    	} else {
    		origin.input().sendMessage("Your action that was sent to the engine deck was not recognized");
    	}
    	return result;
    }
    
    private static EnviroEffect divertPower(EnviroEffect result, Ship ship, String argument){
    	

    	int power = Utils.extractFromDash(argument);
    	
    	if (power > ship.power()){
    		ship.input().sendMessage("Diverting that much power from the main power coils would be catestophic!!!");
    		ship.input().sendMessage("Our current power levels are: ");
    		ship.input().sendMessage("main power: " + ship.power());
    		ship.input().sendMessage("shield power: " + ship.shieldPower());
    		ship.input().sendMessage("weapon power: " + ship.weaponPower());
    		ship.input().sendMessage("engine power: " + ship.enginePower());
    		return result;
    	}
    	
    	if (argument.contains("shields")){
    		ship.addPower(power * -1);
    		ship.addShieldPower(power);
    		ship.input().sendMessage("shield power is now at " + ship.shieldPower());
    		ship.input().sendMessage("main power is down to " + ship.power());
    	} else if (argument.contains("weapons")){
    		ship.addPower(power * -1);
    		ship.addWeaponPower(power);
    		ship.input().sendMessage("weapons power is now at " + ship.weaponPower());
    		ship.input().sendMessage("main power is down to " + ship.power());
    	} else if (argument.contains("thrusters") || argument.contains("engine")){
    		ship.addPower(power * -1);
    		ship.addWeaponPower(power);
    		ship.input().sendMessage("engine power is now at " + ship.enginePower());
    		ship.input().sendMessage("main power is down to " + ship.power());
    	}
    	return result;
    }
    	
    	
    	
    	
    private static EnviroEffect boost(EnviroEffect result, Ship ship, String argument){
    	boolean left = false;
    	boolean validParam = false;
    	if (argument.contains("left")){
    		left = true;
    		validParam = true;
    	} if (argument.contains("right")){
    		left = false;
    		validParam = true;
    	}
    	if (validParam) { 

    		int number = Utils.extractFromDash(argument);
    		String direction = "";
    		if (argument.contains("Deg")){
    		
    		} else if (argument.contains("%")){
    		
    		}else{
    			if(left){
    				ship.addFacing(number * -1);
    				direction = "left";
    			}else{
    				ship.addFacing(number);
    				direction = "right";
    			}
    		}
    		ship.input().sendMessage("We have turned " + direction + " by " + number + " marks (" + number*22.5 + " degrees)");
    	}
    	return result;
    }
    
    private static EnviroEffect destruct(EnviroEffect result, Ship ship, String argument){
    	ship.isDestroyed(true);
    	return result;
    }
     
    private static EnviroEffect stabalize(EnviroEffect result, Ship ship){
    	ship.instability(0);
    	ship.input().sendMessage("We are stable now!");
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
    		ship.input().sendMessage("we are on the move");
    	} else if (argument.contains("sidekicks") && argument.contains("left")){
    		moveForward = (int) ((ship.enginePower() / 2) * throttle);
    		moveSide = (int) ((ship.enginePower() / 2) * throttle);
    		ship.input().sendMessage("we are on the move");
    	} else if (argument.contains("sidekicks") && argument.contains("right")){
    		moveForward = (int) ((ship.enginePower() / 2) * throttle);
    		moveSide = (int) ((ship.enginePower() / 2) * throttle);
    		ship.input().sendMessage("we are on the move");
    	} else if (argument.contains("halters")){
    		moveForward = (int) (((ship.enginePower() / 2) * -1) * throttle);
    		ship.input().sendMessage("we are on the move");
    	}else{
    		ship.input().sendMessage("What engines do you want to activate?");
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
