import static org.junit.Assert.*;

import org.junit.Test;

import util.*;

public class MathTests {

	@Test
	public void LineCreation1(){
		Line line = new Line(0, 0, 2);
		assertEquals(line.x1, 0);
		assertEquals(line.x2, 1);
		assertEquals(line.y1, 0);
		assertEquals(line.y2, 1);
		assertEquals(line.isHorizontal, false);
	}

	@Test
	public void LineCreation2(){
		Line line = new Line(0, 1, 2);
		assertEquals(line.x1, 0);
		assertEquals(line.x2, 1);
		assertEquals(line.y1, 1);
		assertEquals(line.y2, 2);
		assertEquals(line.isHorizontal, false);
	}
		
	@Test
	public void LineCreation3(){
		Line line = new Line(1, 0, 2);
		assertEquals(line.x1, 1);
		assertEquals(line.x2, 2);
		assertEquals(line.y1, 0);
		assertEquals(line.y2, 1);
		assertEquals(line.isHorizontal, false);
	}
		
	@Test
	public void LineCreation4(){
		Line line = new Line(1, 1, 2);
		assertEquals(line.x1, 1);
		assertEquals(line.x2, 2);
		assertEquals(line.y1, 1);
		assertEquals(line.y2, 2);
		assertEquals(line.isHorizontal, false);
	}

		@Test
	public void LineCreation5(){
		Line line = new Line(0, 0, 10);
		assertEquals(line.x1, 0);
		assertEquals(line.x2, -1);
		assertEquals(line.y1, 0);
		assertEquals(line.y2, -1);
		assertEquals(line.isHorizontal, false);
	}

	@Test
	public void LineCreation6(){
		Line line = new Line(0, 1, 10);
		assertEquals(line.x1, 0);
		assertEquals(line.x2, -1);
		assertEquals(line.y1, 1);
		assertEquals(line.y2, 0);
		assertEquals(line.isHorizontal, false);
	}
		
	@Test
	public void LineCreation7(){
		Line line = new Line(1, 0, 10);
		assertEquals(line.x1, 1);
		assertEquals(line.x2, 0);
		assertEquals(line.y1, 0);
		assertEquals(line.y2, -1);
		assertEquals(line.isHorizontal, false);
	}
		
	@Test
	public void LineCreation8(){
		Line line = new Line(1, 1, 10);
		assertEquals(line.x1, 1);
		assertEquals(line.x2, 0);
		assertEquals(line.y1, 1);
		assertEquals(line.y2, 0);
		assertEquals(line.isHorizontal, false);
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

}
