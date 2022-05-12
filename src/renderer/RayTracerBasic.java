package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

public class RayTracerBasic extends RayTracerBase {

	@Override
	public Color traceRay(Ray ray) {
		Point point = ray.findClosestPoint(scene._geometries.findIntersections(ray));
		if (point == null) {
			return scene.get_background();
		}
		return calcColor(point);
	}
	
	public Color calcColor(Point p) {
		return scene.get_ambiantLight().getIntensity();
	}

	public RayTracerBasic(Scene scene) {
		super(scene);
	}

}
