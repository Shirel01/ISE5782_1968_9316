package geometries;
import java.util.List;
import java.util.Objects;

import primitives.*;
                                                            /**add @ in modues that umplements the method??*/
public  abstract class Intersectable {
	   public List<Point> findIntersections(Ray ray) {
	        var geoList = findGeoIntersections(ray);
	        return geoList == null ? null
	                : geoList.stream().map(gp -> gp.point).toList();
	    }
	
	 /**
     * Finds Geo Intersections with a ray
     * @param ray
     * @return list of geo Point
     */
    public final List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray,Double.POSITIVE_INFINITY);
    }
    public final List<GeoPoint>findGeoIntersections(Ray ray,double maxDistance){
        return findGeoIntersectionsHelper(ray,maxDistance);
    }

    /**
     * Abstract method to find all the Geo Intersections with a ray
     * @param ray
     * @return list of GeoPoint
     */
    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray,double maxDistance);
	
	
	public static class GeoPoint {
		public Geometry geometry;
		public Point point;
		/**
         * Constructor
         *
         * @param geometry the geometry
         * @param point    the point
         */
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }

        /**
         * Function ToString
         * @return a string with the informations of the GeoPoint
         */
        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }

        /**
         * Function equals
         * @param o
         * @return bool
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(geometry, geoPoint.geometry) && Objects.equals(point, geoPoint.point);
        }

        /**
         * Hash Code
         * @return
         */
        @Override
        public int hashCode() {
            return Objects.hash(geometry, point);
        }
    }
}
		
		


