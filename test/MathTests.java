import static org.junit.Assert.*;

import org.junit.Test;

import util.*;

public class MathTests {

	@Test
	public void LineCreation1(){
		Line line = new Line(0, 0, 2);
		assertEquals(line.x1(), 0);
		assertEquals(line.x2(), 1);
		assertEquals(line.y1(), 0);
		assertEquals(line.y2(), 1);
		assertEquals(line.isHorizontal(), false);
	}

	@Test
	public void LineCreation2(){
		Line line = new Line(0, 1, 2);
		assertEquals(line.x1(), 0);
		assertEquals(line.x2(), 1);
		assertEquals(line.y1(), 1);
		assertEquals(line.y2(), 2);
		assertEquals(line.isHorizontal(), false);
	}
		
	@Test
	public void LineCreation3(){
		Line line = new Line(1, 0, 2);
		assertEquals(line.x1(), 1);
		assertEquals(line.x2(), 2);
		assertEquals(line.y1(), 0);
		assertEquals(line.y2(), 1);
		assertEquals(line.isHorizontal(), false);
	}
		
	@Test
	public void LineCreation4(){
		Line line = new Line(1, 1, 2);
		assertEquals(line.x1(), 1);
		assertEquals(line.x2(), 2);
		assertEquals(line.y1(), 1);
		assertEquals(line.y2(), 2);
		assertEquals(line.isHorizontal(), false);
	}

		@Test
	public void LineCreation5(){
		Line line = new Line(0, 0, 10);
		assertEquals(line.x1(), 0);
		assertEquals(line.x2(), -1);
		assertEquals(line.y1(), 0);
		assertEquals(line.y2(), -1);
		assertEquals(line.isHorizontal(), false);
	}

	@Test
	public void LineCreation6(){
		Line line = new Line(0, 1, 10);
		assertEquals(line.x1(), 0);
		assertEquals(line.x2(), -1);
		assertEquals(line.y1(), 1);
		assertEquals(line.y2(), 0);
		assertEquals(line.isHorizontal(), false);
	}
		
	@Test
	public void LineCreation7(){
		Line line = new Line(1, 0, 10);
		assertEquals(line.x1(), 1);
		assertEquals(line.x2(), 0);
		assertEquals(line.y1(), 0);
		assertEquals(line.y2(), -1);
		assertEquals(line.isHorizontal(), false);
	}
		
	@Test
	public void LineCreation8(){
		Line line = new Line(1, 1, 10);
		assertEquals(line.x1(), 1);
		assertEquals(line.x2(), 0);
		assertEquals(line.y1(), 1);
		assertEquals(line.y2(), 0);
		assertEquals(line.isHorizontal(), false);
	}
	
	@Test
	public void pointIsLeftTest1() {
		Line line = new Line(0, 0, 2);
		assertTrue(line.pointIsLeft(0, 1));
		assertTrue(!line.pointIsLeft(2, -1));
		assertTrue(!line.pointIsLeft(1, 0));
		assertTrue(line.pointIsLeft(2, 3));
		assertTrue(line.pointIsLeft(-2, -1));
	}
	
	@Test
	public void pointIsLeftTest2() {
		Line line = new Line(0, 0, 16);
		assertTrue(!line.pointIsLeft(1, 1));
		assertTrue(!line.pointIsLeft(1, -1));
		assertTrue(line.pointIsLeft(-1, -1));
		assertTrue(line.pointIsLeft(-1, 1));
	}
	
	@Test
	public void pointIsLeftTest3() {
		Line line = new Line(0, 0, 13);
		assertTrue(!line.pointIsLeft(1, 1));
		assertTrue(line.pointIsLeft(1, -1));
		assertTrue(line.pointIsLeft(-1, -1));
		assertTrue(!line.pointIsLeft(-1, 1));
	}

	@Test
	public void pointIsLeftTest4() {
		Line line = new Line(0, 4, 6);
		//assertTrue(line.pointIsLeft(0, 3));
		//assertTrue(line.pointIsLeft(0, -4));
		//assertTrue(line.pointIsLeft(2, 0));
		assertTrue(line.pointIsLeft(5, 5));
	}	@Test
	public void giveMovementTest1() {
		int[] coord = Utils.giveMovement(0, 20, 16);
		assertEquals(0, coord[0]);
		assertEquals(20, coord[1]);
	}	@Test
	public void giveMovementTest2() {
		int[] coord = Utils.giveMovement(0, 20, 4);
		assertEquals(20, coord[0]);
		assertEquals(0, coord[1]);
	}	@Test
	public void giveMovementTest3() {
		int[] coord = Utils.giveMovement(0, 20, 8);
		assertEquals(0, coord[0]);
		assertEquals(-20, coord[1]);
	}	@Test
	public void giveMovementTest4() {
		int[] coord = Utils.giveMovement(0, 20, 12);
		assertEquals(-20, coord[0]);
		assertEquals(0, coord[1]);
	}	@Test
	public void giveMovementTest5() {
		int[] coord = Utils.giveMovement(5, 5, 16);
		assertEquals(-5, coord[0]);
		assertEquals(5, coord[1]);
	}	@Test
	public void giveMovementTest6() {
		int[] coord = Utils.giveMovement(0, 10, 2);
		assertEquals(7, coord[0]);
		assertEquals(7, coord[1]);
	}	@Test
	public void giveMovementTest7() {
		int[] coord = Utils.giveMovement(0, 10, 14);
		assertEquals(-7, coord[0]);
		assertEquals(7, coord[1]);
	}	@Test
	public void giveMovementTest8() {
		int[] coord = Utils.giveMovement(0, 10, 6);
		assertEquals(7, coord[0]);
		assertEquals(-7, coord[1]);
	}	@Test
	public void giveMovementTest9() {
		int[] coord = Utils.giveMovement(0, 10, 10);
		assertEquals(-7, coord[0]);
		assertEquals(-7, coord[1]);
	}	@Test
	public void giveMovementTest10() {
		int[] coord = Utils.giveMovement(0, 10, 1);
		assertEquals(3, coord[0]);
		assertEquals(9, coord[1]);
	}
}
