package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import components.map.Map;
import components.set.Set;

import gameEngine.Command;
import gameEngine.Ship;

public final class ComputerAI implements Input {

	private Ship ship;
	private int BASEATTACKRT = 10;
	private int attackRT = BASEATTACKRT;
	private int runRT;
	private int stabalizeRT;
	private int shieldDivertRT;
	private int weaponDivertRT;
	private int enginesDivertRT;
	private List<Ship> allies;
	
    public ComputerAI() {
    }

    public static void main(String[] args) {

    }

    public void addShip(Ship ship){
    	this.ship = ship;
    }
    
	@Override
	public Command askForCommand() {
		Command command = null;
		
		this.updateDesires();
		
		String wantToDo = this.greatestDesire();
		
		if(wantToDo.equals("attack") && this.isEnemyInRange()){
			String arcToFire = this.arcToFire();
			String bestWeapon = this.bestWeapon(arcToFire);
			this.attackRT = this.BASEATTACKRT;
			command = new Command("weapons fire " + bestWeapon);

		} else if (wantToDo.equals("attack") && ! this.isEnemyInRange()) {
			int turn = findEnemy();
			if (turn < 0){
				command = new Command("engines boost left-" + -1*turn + "-");
			} else if ( turn > 0){
				command = new Command("engines boost right-" + turn + "-");
			} else {
				command = new Command("engines engage thrusters");
			}
			
		}else if (wantToDo.equals("stabalize")){
			command = new Command("engines stablize");
			
		} else if (wantToDo.equals("run")){
			command = new Command("engines engage thrusters");
			
		} else if (wantToDo.equals("shieldDivert")){
			int power = this.ship.power() / 3;
			command = new Command("engines divert-power shields" + "-" + power + "-");

		} else if (wantToDo.equals("weaponsDivert")){
			int power = this.ship.power() / 3;
			command = new Command("engines divert-power weapons" + "-" + power + "-");

		} else if (wantToDo.equals("enginesDivert")){
			int power = this.ship.power() / 3;
			command = new Command("engines divert-power engines" + "-" + power + "-");

		}
		return command;
	}
	
	private String greatestDesire(){
		int largest = Collections.max(Arrays.asList(this.attackRT, this.weaponDivertRT, this.shieldDivertRT, this.enginesDivertRT, this.runRT, this.stabalizeRT));	
		String desire = "";
		if(this.attackRT == largest){
			desire = "attack";
		} else if (this.weaponDivertRT == largest){
			desire = "weaponsDivert";
		} else if (this.shieldDivertRT == largest){
			desire = "shieldsDivert";
		} else if (this.enginesDivertRT == largest){
			desire = "enginesDivert";
		} else if (this.runRT == largest){
			desire = "run";
		} else if (this.stabalizeRT == largest){
			desire = "stabalize";
		}
		return desire;
	}
	
	private void updateDesires(){
		this.attackRT += 1;
		this.runRT = this.ship.maxHealth() - this.ship.health(); 
		this.stabalizeRT = this.ship.instability();
	}
	
	private boolean isEnemyInRange(){
		List<Ship> ships = this.ship.battleController().otherShips(this.ship);
		ships = util.Utils.removeNotInArc(this.ship, ships);
		Ship target = util.Utils.findNearest(this.ship, ships);
		boolean isEnemy = true;
		if(target == null){
			isEnemy = false;
		}
		if(this.allies != null){
			isEnemy = false;
			int size = this.allies.size();
			for (int i = 0; i < size; i++){
				if(target != this.allies.get(i)){
					isEnemy = true;
				}
			}
		} 
		return isEnemy;
		
	}
	
	private String arcToFire(){
		String arc = "front";
		
		return arc;
	}
	
	private int findEnemy(){
		Ship enemy = util.Utils.findNearest(this.ship, this.ship.battleController().ships(), this.allies);
		
		String face = util.Utils.whichFace(this.ship, enemy);
		
		/*
		int distance = util.Utils.findDistance(this.ship, enemy);
	
		int size = this.ship.weapons().size();
		boolean outOfRange = true;
		for (int i = 0; i < size; i++){
			if (this.ship.weapons().get(i).range() >= distance){
				outOfRange = true;
			}
		}
		 */

		int turn = 0;
		if(face.equals("front")){
			turn = 0;
		} else if (face.equals("left")){
			turn = -4;
		} else if (face.equals("right")){
			turn = 4;
		} else if (face.equals("rear")){
			turn = 8;
		}

		return turn;
	}
	
	private String bestWeapon(String arc){
		String weapon = "";
		
		int size = this.ship.weapons().size();
		for (int i = 0; i < size; i++){
			if(arc.equals("front") && this.ship.weapons().get(i).facing() == 16){
				weapon = this.ship.weapons().get(i).name();
			} else if(arc.equals("left") && this.ship.weapons().get(i).facing() > 8 && this.ship.weapons().get(i).facing() < 16){
				weapon = this.ship.weapons().get(i).name();
			} else if(arc.equals("right") && this.ship.weapons().get(i).facing() > 0 && this.ship.weapons().get(i).facing() < 8){
				weapon = this.ship.weapons().get(i).name();
			} else if(arc.equals("rear") && this.ship.weapons().get(i).facing() == 8){
				weapon = this.ship.weapons().get(i).name();
			}
		}
		
		return weapon;
		
		
		
	}

	@Override
	public void sendMessage(String message) {
		// do nothing, this is a computer, maybe later I could add AI that reacts to the results it gets back
	}

	@Override
	public void giveCommand(String command) {
		// TODO Auto-generated method stub
		
	}

}
