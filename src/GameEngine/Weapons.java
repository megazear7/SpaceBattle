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
    	} else {
    		origin.input().sendMessage("Your action that was sent to the weapon platform room was not recognized");
    	}

    	return result;
    }

    private static EnviroEffect fire(EnviroEffect result, Ship attacker, String argument, BattleController battleField){
    
    	Weapon weapon = attacker.weapon(argument);
    	
    	if (weapon == null){
    		attacker.input().sendMessage("We could not find a weapon by that name, your weapons are: ");
     		int size = attacker.weapons().size();
     		for (int i = 0; i < size; i++){
     			attacker.input().sendMessage("Your " + attacker.weapons().get(i).name() + 
     					"'s have damage: " + attacker.weapons().get(i).damage() + 
     					", have a range of " + attacker.weapons().get(i).range() + 
     					", are pointing in a position of " + attacker.weapons().get(i).facing() + 
     					" and are " + attacker.weapons().get(i).type() + " weapons");
     		}
    		return result;
    	}
    	
    	Ship target = Utils.keepBestTarget(attacker, weapon.realFacing(), weapon.range(), battleField.otherShips(attacker));
   
    	if(!target.realShip()){
    		result.addMessage("No enemy in range of that weapon");
    	} else {

    		int damage = Utils.determineDamage(attacker, weapon, target);
    		target.addHealth(damage * -1);

    		if (weapon.typeNum() == 0){
    			target.addInstability(damage);
    		} else {
    			String face = Utils.whichFace(attacker, target);
    			if(face.equals("front")){
    				target.addInstability(damage - target.leftShield());
    			} else if (face.equals("left")){
    				target.addInstability(damage - target.leftShield());
    			} else if (face.equals("right")){
    				target.addInstability(damage - target.rightShield());
    			} else if (face.equals("rear")){
    				target.addInstability(damage - target.rearShield());
    			}	
    		}
    	
    		result.addMessage("The " + attacker.shipName() + " hit the " + target.shipName() + " in the " + Utils.whichFace(attacker, target) +
    				" for " + damage + " damage.");
    	} 
    	return result;
    }

    public static void main(String[] args) {
    }

}
