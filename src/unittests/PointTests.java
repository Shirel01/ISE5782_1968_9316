/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Point;
import primitives.Vector;

/**
 * @author shire
 *
 */
class PointTests {

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 */
	@Test
	  public void testSubtract() {
        Point p1 = new Point(1, 1, -100);
        Point p2 = new Point(-1, 1, -99);
        Vector result;
        result = p1.subtract(p2);
    }


	/**
	 * Test method for {@link primitives.Point#add(primitives.Vector)}.
	 */
	@Test
	void testAdd() {
		Point p1=new Point (1,2,3);
		Vector p2= new Vector(2.0,2.0,3.0);
		assertEquals(p1.add(p2),new Point(3,4,6));
	}

	/**
	 * Test method for {@link primitives.Point#distanceSquared(primitives.Point)}.
	 */
	@Test
	
	    void testDistanceSquared() {
		Point p1=new Point(1.0,0.0,0.0);
		Point p2=new Point(0.0,1.0,0.0);
		assertEquals(p1.distanceSquared(p2), 2);
	}

	/**
	 * Test method for {@link primitives.Point#distance(primitives.Point)}.
	 */
	@Test
	void testDistance() {
		Point p1=new Point(1.0,0.0,0.0);
		Point p2=new Point(0.0,1.0,0.0);
		assertEquals(p1.distance(p2),Math.sqrt(2));
	}

}
