package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase {

	@Override
	 public Color traceRay(Ray ray, boolean isSoftShadows) {
		Point point = ray.findClosestPoint(_scene._geometries.findIntersections(ray));
		if (point == null) {
			return _scene.get_background();
		}
		return calcColor(point);
	}
	
	

	        /**List<GeoPoint> myPoints = _scene.geometries.findGeoIntersections(ray);
	        if (myPoints != null) {
	            GeoPoint myPoint = ray.findClosestGeoPoint(myPoints);
	            return calcColor(myPoint, ray);
	        }
	        return _scene.background;
	    }**/
	
	
	public Color calcColor(Point p) {
		return _scene.get_ambiantLight().getIntensity();
	}

	public RayTracerBasic(Scene scene) {
		super(scene);
	}

}
