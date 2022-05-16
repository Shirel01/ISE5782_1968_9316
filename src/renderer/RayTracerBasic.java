package renderer;

import java.util.List;

import geometries.Intersectable.GeoPoint;
import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase {

	@Override
	// public Color traceRay(Ray ray, boolean isSoftShadows) {
	//	Point point = ray.findClosestPoint(_scene._geometries.findIntersections(ray));
	//	if (point == null) {
	//		return _scene.get_background();
	//	}
	//	return calcColor(point);
	//}
	
	 public Color traceRay(Ray ray, boolean isSoftShadows) {

	        List<GeoPoint> points = _scene.geometries.findGeoIntersections(ray);
	        if (points != null) {
	            GeoPoint p = ray.findClosestGeoPoint(points);
				return calcColor(p, ray);
	        }
	        return _scene.get_background();
	    }

	        /**List<GeoPoint> myPoints = _scene.geometries.findGeoIntersections(ray);
	        if (myPoints != null) {
	            GeoPoint myPoint = ray.findClosestGeoPoint(myPoints);
	            return calcColor(myPoint, ray);
	        }
	        return _scene.background;
	    }**/
	
	
		
	 private Color calcColor(GeoPoint intersection, Ray ray) {
        return _scene.ambientlight.getIntensity()
                .add(intersection.geometry.getEmission())
                .add(calcLocalEffects(intersection, ray));
    }

	public RayTracerBasic(Scene scene) {
		super(scene);
	}

}
