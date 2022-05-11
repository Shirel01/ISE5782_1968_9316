/**
 * 
 */
package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Vector;

/**
 * @author shire
 *
 */
class VectorTest {

	@Test
    void testLengthSquared() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);
        Vector v2 = new Vector(-1.0, -1.0, -1.5);

        v1 = v1.add(v2);
        assertEquals(new Vector(0.0, 0.0, -0.5), v1);

        v2 = v2.add(v1);
        assertEquals(new Vector(-1.0, -1.0, -2.0), v2);
    }

    @Test
    void testDotProduct() {
    	Vector v1=new Vector(7.0, 1.0, 2.0);
    	Vector v2=new Vector(2.0, -3.0, 1.0);
    	assertEquals(v1.dotProduct(v2),13);
    
    }

    @Test
    void testCrossProduct() {
    	Vector v1=new Vector(2.0,1.0,0.0);
    	Vector v2=new Vector(3.0,1.0,2.0);
    	assertEquals(v1.crossProduct(v2),new Vector(2,-4,-1));
    }

    @Test
    void testNormalize() {
    	Vector v1=new Vector(2.0,3.0,1.0);
    	double lenV1=Math.sqrt(14);
    	assertEquals(v1.normalize(),new Vector(2.0/lenV1,3.0/lenV1,1.0/lenV1));
    	
    }

}
