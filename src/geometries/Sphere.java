/**
 * 
 */
package geometries;

import java.util.List;
import geometries.*;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
//import unittests.List;
import static primitives.Util.alignZero;


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


	

	@Override
    public List<Point> findIntersections(Ray ray) {
        Point P0 = ray.getPoint();
        Vector v = ray.getDir();

        if (P0.equals(_center)) {
            return List.of(_center.add(v.scale(_radius)));
        }

        Vector U = _center.subtract(P0);

        double tm = alignZero(v.dotProduct(U));
        double d = alignZero(Math.sqrt(U.lengthSquared() - tm * tm));

        // no intersections : the ray direction is above the sphere
        if (d >= _radius) {
            return null;
        }

        double th = alignZero(Math.sqrt(_radius * _radius - d * d));
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);

        if (t1 > 0 && t2 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
//            Point3D P2 = P0.add(v.scale(t2));
            Point P1 =ray.getPoint(t1);
            Point P2 =ray.getPoint(t2);
            return List.of(P1, P2);
        }
        if (t1 > 0) {
//            Point3D P1 = P0.add(v.scale(t1));
            Point P1 =ray.getPoint(t1);
            return List.of(P1);
        }
        if (t2 > 0) {
//            Point3D P2 = P0.add(v.scale(t2));
            Point P2 =ray.getPoint(t2);
            return List.of(P2);
        }
        return null;

    }


	

}