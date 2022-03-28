/**
 * 
 */
package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * @author 
 *
 */
public class Tube   {

	Ray _axisRay;
	double _radius;
	public Tube(Ray ray, double d) {
		_axisRay=ray;
		_radius=d;
	}

	public Vector getNormal( ) {
		return null;
	}

	public Vector getNormal(Point point) {

        Point P0 = _axisRay.getPoint();  //Initial point
        Vector v = _axisRay.getDir();  //Vector director of the ray

        Vector P0_P = point.subtract(P0);

        double t = alignZero(v.dotProduct(P0_P));

        if (isZero(t)) {
            return P0_P.normalize();
        }

        Point o = (Point) P0.add(v.scale(t));

        if (point.equals(o)) {
            throw new IllegalArgumentException("point cannot be on the tube axis");
        }

        Vector n = point.subtract(o).normalize();

        return n;
    }

	

	public Object getAxisRay() {
		return _axisRay;
	}
	
}
