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
public final class GuiScene {

    private GuiScene() {
    }

    public static void main(String[] args) {
        
        BattleController control = new BattleController();
        List<Ship> temp = new ArrayList<Ship>();

        List<Weapon> enterpriseWeapons = new ArrayList<Weapon>();
        Weapon lasers = new Weapon(4, "phase", "lasers", 15, 16);
        Weapon rightMissles = new Weapon(5, "phyiscal", "right-missles", 15, 3);
        Weapon leftMissles = new Weapon(5, "phyiscal", "left-missles", 15, 13);
        enterpriseWeapons.add(lasers);
        enterpriseWeapons.add(leftMissles);
        enterpriseWeapons.add(rightMissles);

        List<Weapon> deathStarWeapons = new ArrayList<Weapon>();
        Weapon beam = new Weapon(8, "phase", "deathbeam", 30, 16);
        deathStarWeapons.add(lasers);
        deathStarWeapons.add(beam);
        
        GuiInput enterpriseInput = new GuiInput(control);
        GuiInput deathstarInput = new GuiInput(control);
        
        Ship enterprise = new Ship(control, 10, 10, 10, 10, 10, 10, 10, 10, 4, 0, 8, enterpriseInput , "The Enerprise",
        		enterpriseWeapons);
        Ship deathstar = new Ship(control, 10, 10, 10, 10, 10, 10, 10, 10, -4, 0, 16, deathstarInput, "The Death Star",
        		deathStarWeapons);
        
        enterpriseInput.addGui(new GuiTest(enterpriseInput));
        deathstarInput.addGui(new GuiTest(deathstarInput));
        enterpriseInput.addShip(enterprise);
        deathstarInput.addShip(deathstar);

        temp.add(enterprise);
        temp.add(deathstar);

        control.ships(temp);
        
        
        
    }

    private static void endOfGame(Ship winner, Ship loser){
    	System.out.println(loser.shipName() + " has been destoryed!");
    	System.out.println(winner.shipName() + " is the victor!!!");
    }

}
