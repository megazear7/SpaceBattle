import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public final class EnviroEffect {

	private String message;
	
    public EnviroEffect() {
    } 

    void addMessage(String message){
    	if(this.message != null){
    		this.message = this.message + message + "\n";
    	}else if(this.message == null){
    		this.message = message + "\n";
    	}	
    }
    
    String message(){
    	return this.message;
    }
    
    public static void main(String[] args) {
    }

}
