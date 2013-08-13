package util;

import gameEngine.Command;
import gameEngine.Ship;


public interface Input {
	
	public Command askForCommand();
	
	public void sendMessage(String message);
	
	public void giveCommand(String command);

	public void addShip(Ship ship);
	

}
