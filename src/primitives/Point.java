/**
 * 
 */
package primitives;

//import com.sun.org.apache.bcel.internal.Const;

/**
 * @author 
 *
 */
public class Point {

	/**
	 * 
	 */
public final Double3 xyz;

public static final Point zero=new Point(0,0,0);
public Point(Double3 n) {
	 xyz=n;	
	}
public Point(double n,double n1,double n2) {
	xyz=new Double3(n,n1,n2);
	}

@Override
public boolean equals(Object obj) {
if (this == obj) return true;
if (obj == null) return false;
if (!(obj instanceof Point)) return false;
Point other = (Point)obj;
return xyz.equals(other.xyz);
}
@Override
public String toString() { return xyz.toString(); }

public Vector subtract(Point p){
	  return new Vector(xyz.subtract(p.xyz));
}
public Point add(Vector v){
	return  new Point(xyz.add(v.xyz));
}
public double distanceSquared(Point p) {
	 double x1 = xyz.d1;
     double y1 = xyz.d2;
     double z1 = xyz.d3;

     double x2 = p.xyz.d1;
     double y2 = p.xyz.d2;
     double z2 = p.xyz.d3;

  return ((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y1) + (z2 - z1)*(z2 - z1));
 }

public double distance(Point p){
	return Math.sqrt(distanceSquared(p));
	
}
}

