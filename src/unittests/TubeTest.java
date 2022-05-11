package unittests;


import geometries.Tube;
import primitives.Vector;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TubeTest {

	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Tube tube = new Tube( new Ray(new Point(0, 0, 1), new Vector(0, -1, 0)),1.0);
        Vector normal = tube.getNormal(new Point(0, 0.5, 2)).normalize();

        double dotProduct = normal.dotProduct(((Ray) tube.get_axisRay()).getDir()); 
        assertEquals(0d, dotProduct, "ERROR: Normal is not orthogonal to the tube");

        boolean firstnormal = new Vector(0, 0, 1).equals(normal);
        boolean secondtnormal = new Vector(0, 0, -1).equals(normal);

        assertTrue(firstnormal || secondtnormal, "ERROR: Bad normal to tube");

        assertEquals(new Vector(0, 0, 1), normal, "ERROR: Bad normal to tube");
    
  //==================Boundary====================
	
}}
