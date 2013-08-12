package gameEngine;

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
    	}
    	
    	return result;
    }
    
    private static EnviroEffect boost(EnviroEffect result, Ship ship, String argument){
    	if(argument.contains("front")){
    		ship.addFrontShield(ship.shieldPower());
    		ship.addShieldPower(-1);
    	} else if(argument.contains("left")){
    		ship.addLeftShield(ship.shieldPower());
    		ship.addShieldPower(-1);
    	} else if(argument.contains("right")){
    		ship.addRightShield(ship.shieldPower());
    		ship.addShieldPower(-1);
    	} else if(argument.contains("rear")){
    		ship.addRightShield(ship.shieldPower());
    		ship.addShieldPower(-1);
    	}
    	return result;
    }

    public static void main(String[] args) {
    }

}
