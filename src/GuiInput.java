import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class GuiInput implements Input {

	private GuiTest gui;
	private BattleController control;
	private Ship ship;
	
    public GuiInput(BattleController control) {
    	this.control = control;
    	this.gui = gui;
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
