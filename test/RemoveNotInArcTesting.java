import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import util.Utils;
import util.shipCreation;
import gameEngine.Ship;

public class RemoveNotInArcTesting {

	@Test
	public void test() {
		// these ships are inside the ships arc
		Ship one = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, -4, 16, null, "The Enerprise", null);
		Ship two = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 4, 8, null, "The Enerprise", null);
		Ship three = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 0, 8, null, "The Enerprise", null);
		Ship four = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 0, 8, null, "The Enerprise", null);
		Ship five = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 0, 5, null, "The Enerprise", null);
		
		// the ships are outside of the ships arc
		Ship six = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, -1, 8, null, "The Enerprise", null);

		List<Ship> testList = new ArrayList<Ship>();
		testList.add(two);
		testList.add(three);
		testList.add(four);
		testList.add(five);

		List<Ship> list = new ArrayList<Ship>();
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		list.add(six);

		List<Ship> newList = Utils.removeNotInArc(one, list);
		
		assertEquals(4, newList.size());
		assertEquals(testList, newList);

		assertTrue(true);
	}

	
	@Test
	public void test2() {
		// these ships are inside the ships arc
		Ship one = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 4, 8, null, "the ship", null);
		Ship two = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 3, 8, null, "The Enerprise", null);
		Ship three = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, -4, 16, null, "The Enerprise", null);
		Ship four = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 0, 8, null, "The Enerprise", null);
		Ship five = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 2, 0, 5, null, "The Enerprise", null);
		
		// the ships are outside of the ships arc
		Ship six = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 3, 8, null, "The Enerprise", null);
		Ship seven = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 5, 8, null, "The Enerprise", null);

		List<Ship> testList = new ArrayList<Ship>();
		testList.add(two);
		testList.add(three);
		testList.add(four);
		testList.add(five);

		List<Ship> list = new ArrayList<Ship>();
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		list.add(six);
		list.add(seven);

		List<Ship> newList = Utils.removeNotInArc(one, list);
		
		assertEquals(4, newList.size());
		assertEquals(testList, newList);

		assertTrue(true);
	}
		@Test
	public void test3() {
		Ship one = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 4, 8, null, "The enterprise", null);
		Ship two = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, -4, 16, null, "The deathstar", null);

		List<Ship> testList = new ArrayList<Ship>();
		testList.add(two);

		List<Ship> list = new ArrayList<Ship>();
		list.add(two);

		List<Ship> newList = Utils.removeNotInArc(one, list);
		
		assertEquals(1, newList.size());
		assertEquals(testList, newList);
	}
	@Test
	public void test4() {
		Ship one = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, -6, 8, null, "The enterprise", null);
		Ship two = new Ship(null, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0, -4, 16, null, "The deathstar", null);

		List<Ship> testList = new ArrayList<Ship>();
		testList.add(two);

		List<Ship> list = new ArrayList<Ship>();
		list.add(two);

		List<Ship> newList = Utils.removeNotInArc(one, one.rightFace(), list);
		
		assertEquals(1, newList.size());
		assertEquals(testList, newList);
	}	@Test
	public void test5() {
        Ship one = shipCreation.createShip("enterprise", null, null, -10, -6, 12);
        Ship two = shipCreation.createShip("deathstar", null, null, 0, -4, 16);
		List<Ship> testList = new ArrayList<Ship>();
		testList.add(two);

		List<Ship> list = new ArrayList<Ship>();
		list.add(two);

		List<Ship> newList = Utils.removeNotInArc(one, one.rearFace(), list);
		
		assertEquals(testList, newList);
		assertEquals(1, newList.size());
	}
}
