import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import java.util.List;
import java.util.ArrayList;

public final class BattleController {

	private List<Ship> ships;
	
    public BattleController() {
    	ships = new ArrayList<Ship>();
    }
    public BattleController(List<Ship> ships) {
    	for (int i = 0; i < ships.size(); i++){
    		this.ships.add(ships.get(i));
    	}
    }   
    public void ships(List<Ship> ships) {
    	for (int i = 0; i < ships.size(); i++){
    		this.ships.add(ships.get(i));
    	}
    }   
    public void addShip(Ship ship){
    	this.ships.add(ship);
    }
    
    public List<Ship> ships(){
    	return this.ships;
    }
    

    /**
     * This function takes in a command object and the ship that issues the command, procces's it using the systems classes (as of now that means Engines,
     * Weapons and Shields, but more systems could be added) and returns a EnviroEffect Object
     * @param command The Command to be procesed
     * @return 
     * @returns	a EnviroEffect Object
     */
    public void issueCommand(Command command, Ship origin){
    	EnviroEffect result = new EnviroEffect();
    	if(command.system().equals("engines")){
    		result = Engines.action(this, command, origin);
    	}
    	if(command.system().equals("shields")){
    		result = Shields.action(this, command, origin);
    	}
    	if(command.system().equals("weapons")){
    		result = Weapons.action(this, command, origin);
    	}
    	if(result.message() != null){
    		System.out.print(result.message());
    	}
    }
    
    
    public static void main(String[] args) {
    }

}