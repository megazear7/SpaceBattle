import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class Weapons {

    /**
     * This function, given a action essentially redirects to the correct action function in this class
     * @param action
     * @param origin
     * @param target
     * @return
     */
    public static EnviroEffect action(BattleController battleField, Command command, Ship origin){
    	EnviroEffect result = new EnviroEffect();
    	Ship target = null;
    	if (origin.target() != null){
    		target = origin.target();
    	}
    	if(command.action().equals("fire")){ 
    		if(target != null){
    			result = fire(result, origin, target, command.argument());
    		} else {
    			result.addMessage(origin.shipName() + " is not targeting a ship");
    		}
    	}
    	return result;
    }

    private static EnviroEffect fire(EnviroEffect result, Ship attacker, Ship defender, String argument){
    	if(argument.contains("all")){
    		int damage = attacker.weaponDamage();
    		damage = damage - defender.frontShield();
    		defender.addFrontShield(damage * -1);
    	}
    	
    	return result;
    }

    public static void main(String[] args) {
    }

}
