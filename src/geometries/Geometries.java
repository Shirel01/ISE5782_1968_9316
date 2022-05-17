package geometries;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import primitives.Point;
import primitives.Ray;
import java.util.LinkedList;
import java.util.List;
public class Geometries extends Intersectable{

	List<Intersectable> _intersectableList; // list of intersections points
	
	public Geometries() {
        _intersectableList = new LinkedList<>();
    }

    public Geometries(Intersectable... intersectables) {
        _intersectableList = new LinkedList<>();
        Collections.addAll(_intersectableList, intersectables);
    }

    public void add(Intersectable... intersectables) {
        Collections.addAll(_intersectableList, intersectables);
    }


    @Override
    /**Function that returns the list of all the intersections of a shape with a ray
     * @param Ray: the ray that intersects the shape
     * @return the list of all the intersections of the ray with the shape
     * */
    public List<Point> findIntersections(Ray ray) {
        List<Point> result = null;
        for (var item : _intersectableList) {
            List<Point> itemList = item.findIntersections(ray);
            if (itemList != null) {
                if (result == null) {
                    result = new LinkedList<>();
                }
                result.addAll(itemList);
            }
        }
        return result;
    }

	@Override
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray, double maxDistance) {
		 List<GeoPoint> intersections = null;
	        for (Intersectable geometry : _intersectableList) {
	            List<GeoPoint> geoIntersections = geometry.findGeoIntersections(ray,maxDistance);
	            if (geoIntersections != null) {
	                if (intersections == null)
	                    intersections = new LinkedList<>();


	                intersections.addAll(geoIntersections);
	            }
	        }
	        return intersections;
	}

	  

	
}
