package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

public abstract class RayTracerBase {
	protected Scene scene;
	
	public RayTracerBase(Scene scene) {
		super();
		this.scene = scene;
	}

	public abstract Color traceRay(Ray r);
}
