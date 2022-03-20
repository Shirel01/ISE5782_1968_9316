/**
 * 
 */
package geometries;

import primitives.Vector;
import primitives.Point;

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
}
