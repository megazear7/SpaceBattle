package util;

import gameEngine.Command;


public interface Input {
	
	public Command askForCommand();
	
	public void sendMessage(String message);
	
	public void giveCommand(String command);
	

}
