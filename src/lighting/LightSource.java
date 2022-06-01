package lighting;

import primitives.*;

public interface LightSource {

    public Color getIntensity(Point p);
    public Vector getL(Point p);
	
	 /**
     * Get distance from the light to the point
     * @param point the point
     * @return the distance
     */
    public double getDistance(Point point);
}