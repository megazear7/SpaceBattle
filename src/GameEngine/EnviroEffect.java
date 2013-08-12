package gameEngine;

public final class EnviroEffect {

	private String message;
	private String shipMessage;
	
    public EnviroEffect() {
    } 

    void addMessage(String message){
    	if(this.message != null){
    		this.message = this.message + message + "\n";
    	}else if(this.message == null){
    		this.message = message + "\n";
    	}	
    }
    
    void addMessageToShip(String message){
    	if(this.shipMessage != null){
    		this.shipMessage = this.shipMessage + message + "\n";
    	}else if(this.shipMessage == null){
    		this.shipMessage = message + "\n";
    	}	
    }
   
    String message(){
    	return this.message;
    }
    String shipMessage(){
    	return this.shipMessage;
    }
    
    public static void main(String[] args) {
    }

}
