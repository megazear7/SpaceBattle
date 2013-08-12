package scenarioGuiTesting;

import gameEngine.BattleController;
import gameEngine.Ship;
import gameEngine.Weapon;

import java.util.List;
import java.util.ArrayList;

import util.shipCreation;

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

        GuiInput enterpriseInput = new GuiInput(control);
        GuiInput deathstarInput = new GuiInput(control);
        
        Ship enterprise = shipCreation.createShip("enterprise", control, enterpriseInput, 0, -4, 16);
        Ship deathstar = shipCreation.createShip("deathstar", control, deathstarInput, 0, 4, 8);
        
        enterpriseInput.addGui(new GuiTest(enterpriseInput));
        deathstarInput.addGui(new GuiTest(deathstarInput));
        enterpriseInput.addShip(enterprise);
        deathstarInput.addShip(deathstar);

        temp.add(enterprise);
        temp.add(deathstar);

        control.ships(temp);
        
        
        
    }

}
