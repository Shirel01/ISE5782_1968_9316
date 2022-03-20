/**
 * 
 */
package geometries;

import primitives.Point;
import primitives.Vector;
/**
 * @author 
 *
 */
public class Triangle extends Polygon {
	Point p1;
	Point p2;
	Point p3;
	public Triangle(Point t1,Point t2,Point t3) {
		super(t1,t2,t3);
	}
	@Override
	public String toString() {
		return "points are"+p1+","+p2+","+p3;
	}
	public Vector getNormal( ) {
		return null;
	}
}
