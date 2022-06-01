package primitives;

import java.util.List;
import geometries.Intersectable.GeoPoint;
public class Ray {
	final Vector dir;
	final Point p0;

	 private static final double DELTA = 0.1;
	 /**
	     * Constructor of the class which receives two parameters
	     * @param _p0 : the initial point
	     * @param _dir :the vector of the direction
	     */
	    public Ray(Point _p0, Vector _dir) {
	        this.p0 = _p0;
	        this.dir = _dir.normalize();
	    }
	    
	/**
     * Constructor of the class which receives three parameters
     * @param head : the initial point
     * @param direction :the vector of the direction
     * @param normal
     */
    public Ray(Point head, Vector direction, Vector normal) {
        Vector delta = normal.scale(normal.dotProduct(direction)>=0? DELTA:-DELTA);
        p0 = head.add(delta);
        dir = direction;
    }
	public Point getPoint(double t) {
		return p0.add(dir.scale(t));
		
	}
 public Vector getDir() {
	  return dir;
 }
  public Point getPoint() {
	  return p0;
  }
  @Override
  public String toString() {
	  return dir.toString()+p0.toString();
  }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Ray))
			return false;
		Ray other = (Ray) obj;
		return other.dir.equals(this.dir) && other.p0.equals(this.p0);
	}
	public Point findClosestPoint(List<Point>points) {
		return points == null || points.isEmpty() ? null
		      : findClosestGeoPoint(points.stream().map(p -> new GeoPoint(null, p)).toList()).point;
	}
	/**
     * Find the closest Geo Point to Ray's origin
     *
     * @param getPointList
     * @return closest GeoPoint
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> getPointList) {

        GeoPoint result = null;
        double distance = Double.MAX_VALUE;
        double d;
        if (getPointList == null)
            return null;


        for (var geo : getPointList) {
            d = geo.point.distance(p0);
            if (d < distance) {
                distance = d;
                result = geo;
            }
        }
        return result;
    }

}
