package renderer;
import geometries.Intersectable.GeoPoint;
import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase {

	 public Color traceRay(Ray ray, boolean b) {
	       
	        var intersections = _scene._geometries.findGeoIntersections(ray);
	        if (intersections == null) return _scene._background;
	        GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);
	        return calcColor(closestPoint);
	    }

	        /**List<GeoPoint> myPoints = _scene.geometries.findGeoIntersections(ray);
	        if (myPoints != null) {
	            GeoPoint myPoint = ray.findClosestGeoPoint(myPoints);
	            return calcColor(myPoint, ray);
	        }
	        return _scene.background;
	    }**/
	
	
	 private Color calcColor(GeoPoint gp) {
	        return _scene._ambientlight.getIntensity()
	                .add(gp.geometry.getEmission());
	    }

	public RayTracerBasic(Scene scene) {
		super(scene);
	}

}
