package scenarioGuiTesting;
import gameEngine.BattleController;
import gameEngine.Command;
import gameEngine.Input;
import gameEngine.Ship;

public final class GuiInput implements Input {

	private GuiTest gui;
	private BattleController control;
	private Ship ship;
	
    public GuiInput(BattleController control) {
    	this.control = control;
    }
	
	@Override
	public Command askForCommand() {
		
		
		String commandString = gui.commandText();
		Command command = new Command(commandString);
		return command;
	}	
    
	public void addGui(GuiTest gui){
		this.gui = gui;
	}
	
	public void addShip(Ship ship){
		this.ship = ship;
	}
	
	public void giveCommand(String commandString){

		Command command = new Command(commandString);
		this.control.issueCommand(command, this.ship);
	}
	
    public static void main(String[] args) {
    }

	@Override
	public void sendMessage(String message) {
		gui.addHistory(message);
	}
  

}
