/**
 * 
 */
package geometries;

import primitives.Vector;

import java.util.List;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;
import primitives.Point;
import primitives.Ray;

/**
 * @author lenovo
 *
 */
public class Plane implements Geometry{

	/**
	 * 
	 */
	final Point _q0;
    final Vector _normal;
/**
 * 
 * @param p
 * @param v
 */
	public Plane(Point p,Vector v) {
		 _q0= p;
		_normal=v;
	}
	public Plane(Point p1, Point p2, Point p3) {
        _q0 =p1;
        
        Vector U = p2.subtract(p1);
        Vector V = p3.subtract(p1);

        Vector N = U.crossProduct(V);

          //right hand rule
        _normal = N.normalize();;
    }
	@Override
	public String toString() {
		return "point:"+ _q0+"normal:"+_normal;
	}
	public Point getPoint() {
		return  _q0;
	}
	public Vector getNormal() {
		return _normal;
	}
	 @Override
	    public Vector getNormal(Point point) {
	        return getNormal();
	    }
	 @Override
	    /** Function that finds all the intersections of a ray with the plane
	     *@param ray :The ray that intersects the plane
	     * @return a list of points which are all the intersections with the ray
	     *
	     * **/
	    public List<Point> findIntersections(Ray ray) {
	        Point P0 = ray.getPoint();
	        Vector v = ray.getDir();
	        Vector n = _normal;

	        //denominator
	        double nv = n.dotProduct(v);

	        if (isZero(nv)) {
	            return null;
	        }

	        Vector P0_Q = _q0.subtract(P0);

	        double t = alignZero(n.dotProduct(P0_Q) / nv);
	        // if t< 0 the ray point to the opposite direction
	        //if t ===0  the ray origin lay with the plane
	        if (t > 0) {
	            Point P = P0.add(v.scale(t));
	            return List.of(P);
	        }
	        return null;
	        }
}
