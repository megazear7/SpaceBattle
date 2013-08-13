package gameEngine;
import util.Utils;

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

    	if(command.action().equals("fire")){ 
    		result = fire(result, origin, command.argument(), battleField);
    	}

    	return result;
    }

    private static EnviroEffect fire(EnviroEffect result, Ship attacker, String argument, BattleController battleField){
    
    	Weapon weapon = attacker.weapon(argument);
    	Ship target = Utils.keepBestTarget(attacker, weapon.realFacing(), weapon.range(), battleField.otherShips(attacker));
   
    	if(!target.realShip()){
    		result.addMessage("No enemy in range of that weapon");
    	} else {

    		int damage = Utils.determineDamage(attacker, weapon, target);
    		target.addHealth(damage * -1);

    		if (weapon.typeNum() == 0){
    			target.instability(damage);
    		} else {
    			String face = Utils.whichFace(attacker, target);
    			if(face.equals("front")){
    				target.instability(damage - target.leftShield());
    			} else if (face.equals("left")){
    				target.instability(damage - target.leftShield());
    			} else if (face.equals("right")){
    				target.instability(damage - target.rightShield());
    			} else if (face.equals("rear")){
    				target.instability(damage - target.rearShield());
    			}	
    		}
    		//target.addShieldPower((-1 * ((int) damage / 5)));
    	
    		result.addMessage("The " + attacker.shipName() + " hit the " + target.shipName() + " in the " + Utils.whichFace(attacker, target) +
    				" for " + damage + " damage.");
    	} 
    	return result;
    }

    public static void main(String[] args) {
    }

}
