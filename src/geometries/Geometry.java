package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

public abstract class Geometry extends Intersectable{
	
private Material material=new Material();
public abstract Vector getNormal(Point p);
protected Color _emission=Color.BLACK;

/**
 * Get emission of the geometry
 *
 * @return Color of the emission
 */
public Color getEmission() {
    return _emission;
}  //function that returns the color of the emission

/**
 * Set emission color of the geometry
 *
 * @param emission Color of the emission
 */
public Geometry setEmission(Color emission) {   //function that sets the received color of the emission
    this._emission = emission;
    return this;
}
public Material getMaterial() {
    return material;
}

public Geometry setMaterial(Material material) {
    this.material = material;
    return this;
}

}
