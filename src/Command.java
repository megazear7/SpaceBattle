import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class Command {

	String system;
	String action;
	String argument;
	
    public Command(String system, String action, String argument) {
    	this.system = system;
    	this.action = action;
    	this.argument = argument;
    }
    
    public Command(String commandString){
    	String[] elements = Utils.elementsFromString(commandString);
    	this.system = elements[0];
    	this.action = elements[1];
    	this.argument = elements[2];
    }
    
    public void system(String system){
    	this.system = system;
    }
    public void action(String action){
    	this.action = action;
    }
    public void argument(String argument){
    	this.argument = argument;
    }
    
    public String system(){
    	return this.system;
    }
    public String action(){
    	return this.action;
    }
    public String argument(){
    	return this.argument;
    }
    
    public static void main(String[] args) {
    }

}
