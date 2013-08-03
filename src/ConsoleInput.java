import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

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
  

}
