
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * @author 
 *
 */
public class Cylinder extends Tube{
	
	double _height;
	
	/**
	 * 
	 * @param ray
	 * @param d
	 * @param height
	 */
	public Cylinder(Ray ray, double d,double height) {
		super(ray, d);
		_height=height;
		
	}
	
	
	public double get_height() {
		return _height;
	}


	@Override
	public String toString() {
		
		return "Cylinder{" + "_height=" + _height + '}';
	}


	//public Vector getNormal( ) {
	//	return null;
	//}
	@Override
	public Vector getNormal(Point p) {
        Point o = _axisRay.getPoint();  //the origin point
        Vector v = _axisRay.getDir();   //the vector director

        // projection of P-O on the ray:
        double t;
        try
        {
            t = alignZero(p.subtract(o).dotProduct(v));
        }
        catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = (Point) o.add(v.scale(t));
        return p.subtract(o).normalize();
    }
	

}
