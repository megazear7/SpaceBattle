import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class GuiInput implements Input {

	private GuiTest gui;
	
    public GuiInput(GuiTest gui) {
    	this.gui = gui;
    }
	
	@Override
	public Command askForCommand() {
		
		
		String commandString = gui.commandText();
		Command command = new Command(commandString);
		return command;
	}	
    
    public static void main(String[] args) {
    }

	@Override
	public void sendMessage(String message) {
		gui.addHistory(message);
	}
  

}
