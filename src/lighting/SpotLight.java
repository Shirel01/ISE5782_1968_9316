package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class SpotLight extends PointLight implements LightSource{


    private Vector direction;

    public SpotLight(Color intensity,Point p,Vector v) {
        super(intensity,p);
        direction=v;
    }
    public Color getIntensity(Point p)
    {
        Color iO=getIntensity();
        double d= p.distance(_position);
         return super.getIntensity();
    }
    /**
     * Get the distance from the point to some point
     * @param point the point
     * @return the distance
     */
    @Override
    public double getDistance(Point point){
        return super.getDistance(point);
    }

}