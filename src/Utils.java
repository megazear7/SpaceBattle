import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import java.util.List;
import java.util.ArrayList;

public final class Utils {

    private Utils() {
    }
    
     public static String[] elementsFromString(String str){
    	String one = "";
    	String two = "";
    	String three = "";
    	str = str.trim();
    	int end = 0;
    	int space = str.indexOf(" ");
    	if(space == -1 && end != 1){
    		one = str.substring(0, str.length());
    		end = 1;
    	}else if (end != 1){
    		one = str.substring(0, space);
    	}
    	if (space != -1){
    		str = str.substring(space, str.length());
    	}
    	str = str.trim();
    	space = str.indexOf(" ");
    	if(space == -1 && end != 1){
    		two = str.substring(0, str.length());
    		end = 1;
    	}else if (end != 1){
    		two = str.substring(0, space);
    	}
    	if (space != -1){
    		str = str.substring(space, str.length());
    	}
    	str = str.trim();
    	space = str.indexOf(" ");
    	if(space == -1 && end != 1){
    		three = str.substring(0, str.length());
    		end = 1;
    	}else if (end != 1){
    		three = str.substring(0, space);
    	}
    	String[] temp = {one, two, three};
    	return temp;
     }
    public static int determineDamage(double shields, int instability, int damage, int type){
    	int result = 0;
    	if(type != 1){
    		result = (int) (damage * shields);
    	}
    	if(type != 3){
    		result = result + instability;
    	}
    	if(type == 2){
    		result = result + instability;
    	}
    	return result;
    }
    
    public static double findDistance(Ship one, Ship two){
    	return 1;
    }
    
    public static List<Ship> removeNotInArc(Ship ship, List<Ship> ships){
    	return null;
    }
     
    public static void main(String[] args) {

    }
    
    

}
