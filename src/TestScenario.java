import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import java.util.List;
import java.util.ArrayList;

/**
 * This is a game implementing the Star Command system. This game has two ship that are identical except the have different names
 * and also are placed 20 spaces away from each other and are facing each other. When one ship is detected as being destroyed, the 
 * game ends and a congratulation message is deisplayed. Both commands are from the command line
 * @author Alex
 *
 */
public final class TestScenario {

    private TestScenario() {
    }

    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        
        BattleController control = new BattleController();
        List<Ship> temp = new ArrayList<Ship>();
        temp.add(new Ship(control, 10, 10, 10, 10, 10, 10, 10, 10, 0, -10, 12, new ConsoleInput(" (Enterprise)--> "), "The Enerprise"));
        temp.add(new Ship(control, 10, 10, 10, 10, 10, 10, 10, 10, 0, -10, 12, new ConsoleInput(" (Death Star)~~> "), "The Death Star"));
        control.ships(temp);
        
        int cont = 1;
        int current = 1;
        int turn = 0;
        while(cont == 1){
        	turn += 1;

        	if(turn % 2 == 0){
        		current = 0;
        	}else{
        		current = 1;
        	}

        	control.issueCommand(control.ships().get(current).input().askForCommand(), control.ships().get(current));

        	if(control.ships().get(0).isDestroyed()){
        		cont = 0;
        		endOfGame(control.ships().get(1), control.ships().get(0));
        	}
        	if(control.ships().get(1).isDestroyed()){
        		cont = 0;
        		endOfGame(control.ships().get(0), control.ships().get(1));
        	}        }
        

        
        out.close();
        in.close();
    }

    private static void endOfGame(Ship winner, Ship loser){
    	System.out.println(loser.shipName() + " has been destoryed!");
    	System.out.println(winner.shipName() + " is the victor!!!");
    }

}
