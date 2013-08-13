package util;
import gameEngine.Command;
import gameEngine.Ship;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public final class ConsoleInput implements Input {

	private String inputMessage;
	
    public ConsoleInput() {
    	this.inputMessage = " >>> ";
    }
	
    public ConsoleInput(String message) {
    	this.inputMessage = message;
    }

	@Override
	public Command askForCommand() {
		SimpleReader in = new SimpleReader1L();
		System.out.print(this.inputMessage);
		Command command = new Command(in.nextLine());
		return command;
	}
    
    public static void main(String[] args) {
    }

	@Override
	public void sendMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void giveCommand(String command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addShip(Ship ship) {
		// TODO Auto-generated method stub
		
	}
  

}
