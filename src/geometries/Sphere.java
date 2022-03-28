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
public class Sphere implements Geometry {
	Point _center;
	Double _radius;
	/**
	 * Constructor 
	 * @param center
	 * @param radius
	 */
	public Sphere(Point center, double radius) {
        _center = center;
        _radius = radius;
    }

	
	public Vector getNormal(Point point) {
		Vector _p0=point.subtract(_center);
		return _p0.normalize();
	}
	
       
}