import static org.junit.Assert.*;
import gameEngine.Command;

import org.junit.Test;



public class Testing {

	@Test
	public void commandFromStringTest1() {
		String str = "  weapons full go adf dasf ";
		Command command = new Command(str);
		assertEquals("weapons", command.system());
		assertEquals("full", command.action());
		assertEquals("go", command.argument());
	}	@Test
	public void commandFromStringTest2() {
		String str = "shield use  all adf";
		Command command = new Command(str);		assertEquals("shield", command.system());
		assertEquals("use", command.action());
		assertEquals("all", command.argument());

	}
	@Test
	public void commandFromStringTest3() {
		String str = "weapons   full go   adf dasf";
		Command command = new Command(str);		assertEquals("weapons", command.system());
		assertEquals("full", command.action());
		assertEquals("go", command.argument());

	}
 	@Test
	public void commandFromStringTest4() {
		String str = "weapons full go";
		Command command = new Command(str);		assertEquals("weapons", command.system());
		assertEquals("full", command.action());
		assertEquals("go", command.argument()); 	}
  	@Test
	public void commandFromStringTest5() {
		String str = "engines destruct";
		Command command = new Command(str);		assertEquals("engines", command.system());
		assertEquals("destruct", command.action());
		assertEquals("", command.argument()); 	}	
 	
        
	 
}
