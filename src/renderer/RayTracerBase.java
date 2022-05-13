package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

public abstract class RayTracerBase {
	protected Scene _scene;
	
	public RayTracerBase(Scene scene) {
		super();
		this._scene = scene;
	}

	public abstract Color traceRay(Ray r,boolean isSoftShadow);
}
