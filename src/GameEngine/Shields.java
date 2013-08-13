package gameEngine;

import util.Utils;

public final class Shields {

    private Shields() {
    }
    
    /**
     * This function, given a action, essentially redirect to the correct action function in this class
     * @param action
     * @param origin
     * @return
     */
    public static EnviroEffect action(BattleController battleField, Command command, Ship origin){
    	EnviroEffect result = new EnviroEffect();
    	
    	if(command.action().equals("boost")){
    		result = boost(result, origin, command.argument());
    	} else {
    		origin.input().sendMessage("Your action that was sent to the shield generator room was not recognized");
    	}
    	
    	return result;
    }
    

    
    private static EnviroEffect boost(EnviroEffect result, Ship ship, String argument){

    	int power = Utils.extractFromDash(argument);
    	
    	if (power < ship.shieldPower()){
    		ship.input().sendMessage("Our shields only have " + ship.shieldPower() + " power");
    		return result;
    	}
    	
    	if(argument.contains("front")){
    		ship.addFrontShield(power);
    		ship.addShieldPower((power / 2) * -1);
    		ship.input().sendMessage("Our front shields are now up to + " + ship.frontShield() + "\nOur shield power is down to " + ship.shieldPower());    	} else if(argument.contains("left")){
    		ship.addLeftShield(ship.shieldPower());
    		ship.addShieldPower((power / 2) * -1);
    		ship.input().sendMessage("Our left shields are now up to + " + ship.leftShield() + "\nOur shield power is down to " + ship.shieldPower());    	} else if(argument.contains("right")){
    		ship.addRightShield(ship.shieldPower());
    		ship.addShieldPower((power / 2) * -1);
    		ship.input().sendMessage("Our right shields are now up to + " + ship.rightShield() + "\nOur shield power is down to " + ship.shieldPower());    	} else if(argument.contains("rear")){
    		ship.addRightShield(ship.shieldPower());
    		ship.addShieldPower((power / 2) * -1);
    		ship.input().sendMessage("Our rear shields are now up to + " + ship.rearShield() + "\nOur shield power is down to " + ship.shieldPower());    	}
    	

    	return result;
    }

    public static void main(String[] args) {
    }

}
