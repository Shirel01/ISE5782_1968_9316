/**
 * 
 */
package geometries;
import primitives.*;
import java.util.List;

import primitives.Point;
import primitives.Ray;
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
	@Override
    /**
     * Function that finds all the intersections of the triangle with an external ray*/
    public List<Point> findIntersections(Ray ray) {

        List<Point> result = plane.findIntersections(ray);

        if(result == null){
            return null;
        }

        Point P0 = ray.getPoint();  //Get the initial point of the ray
        Vector v = ray.getDir();  //Get the vector director of the ray

        Point p1 = vertices.get(0);  //first vertices of the triangle
        Point p2 = vertices.get(1);//second vertices of the triangle
        Point p3 = vertices.get(2);//third vertices of the triangle

        Vector v1 = P0.subtract(p1); //(P0-> p1)
        Vector v2 = P0.subtract(p2); //(P0-> p2)
        Vector v3 = P0.subtract(p3); //(P0-> p3)

        Vector n1 = v1.crossProduct(v2);    // no need to normalise
        Vector n2 = v2.crossProduct(v3);
        Vector n3 = v3.crossProduct(v1);

        double s1 = v.dotProduct(n1);
        double s2 = v.dotProduct(n2);
        double s3 = v.dotProduct(n3);

        if((s1 > 0 && s2 > 0 && s3 >0) ||(s1 < 0 && s2 < 0 && s3 < 0)){  //the three of them have the same sign,it means that the point is inside the triangle. It's an intersection point.
            return result;
        }

        return super.findIntersections(ray);
    }
}
