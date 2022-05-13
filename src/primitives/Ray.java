package primitives;

import java.util.List;
import geometries.Intersectable.GeoPoint;
public class Ray {
	final Vector dir;
	final Point p0;

	public Ray(Point newP,Vector newVec) {
		dir=newVec.normalize();	
		p0=newP;
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
		if(points == null)
			return null;
		Point closet = points.get(0);
		for (Point point3d : points) 
		{
			if(point3d.distance(p0) < closet.distance(p0))
				closet= point3d;
		}
		return closet;
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
